package com.example.sdnapp.ui.main.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.db.Repo
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.main.adapter.ListenerAdapter
import com.example.sdnapp.ui.main.viewModel.MainViewModel
import com.example.sdnapp.util.Status
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(), ListenerAdapter {

    private val viewModel by inject<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = MapsFragment()
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, mapFragment)
                .commit()
        initListenerForViewModel()
        getDataFromServer()


    }





    private fun initAdapter() {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = MainAdapter(arrayListOf(), this)
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter

    }


    private fun getDataFromServer() {
        showLoading()

        viewModel.getAccountEventFromWebServices(
                AccountEventRequest(
                        "",
                        "", "", "", 1, ""
                )
        )

        viewModel.getEventByTagsFromWebServices(
                EventsByTagsRequest(
                        "",
                        "", "", "", 1, ""
                )
        )
        viewModel.getTagsDashboardFromWebServices(
                TagsDashboardRequest("", "", 1,"")
        )
        viewModel.addCameraToWebServices(
                AddCameraRequest("", "", "", "", "",
                        1,"")
        )
        viewModel.getCameraListFromWebServices(
                CameraListRequest("", "", 1,"")
        )
        viewModel.updateCameraFromWebServices(
                UpdateCameraRequest("", "", "", "",
                        "","","",1,"")
        )
        viewModel.deleteCameraFromWebServices(
                DeleteCameraRequest("", "", "", 1,"")
        )
        viewModel.getCameraByIdFromWebServices(
                CameraByIdRequest("", "", "", 1,"")
        )
        viewModel.updateSilentModeFromWebServices(
                UpdateSilentModeRequest("", true, "",
                        "", 1, "")
        )
        viewModel.sendCommandToWebServices(
                SendCommandRequest("", "", "",
                        "", "", 1, "")
        )
        viewModel.getCommandFromWebServices(
                GetCommandRequest("", "", "",
                        "", 1, "")
        )
        viewModel.updateCommandFromWebServices(UpdateCommandRequest(""))



        viewModel.addNewGeoToWebServices(
                AddNewGeoRequest("", "", "", 1,
                        "", "", "", arrayListOf()))

        viewModel.getGeoListFromWebServices(
                GetGeoListRequest("", "", 1,
                        "", "", ""))

        viewModel.deleteGeoFromWebServices(
                DeleteGeoRequest("", "", 1,
                        "", arrayListOf()))

        viewModel.getActivitiesFromWebServices(
                GetActivitiesRequest("", arrayListOf(), "", "",
                        "", "", 1, ""))

        viewModel.getLastActivitiesTypesFromWebServices(
                GetLatsActivitiesTypesRequest("", "", 1, ""))

        viewModel.getLastActivitiesFromWebServices(
                GetLastActivitiesRequest("", arrayListOf(), "",
                        "", 1, ""))

        viewModel.getUsersListFromWebServices(
                GetUsersListRequest("", "", 1, ""))

        viewModel.addUserToWebServices(AddUserRequest(
                "", "", "", "", true,
                true, "", "", "", "",
                "", 1, ""))

        viewModel.editUserToWebServices(EditUserRequest(
                "", "", "", true,
                true, "", "", "", "",
                1, ""))
        viewModel.deleteUserFromWebServices(DeleteUserRequest(
                "", "", "", "", 1, ""))

        viewModel.getCategoryListFromWebServices(
                GetCategoryListRequest("", "", 1, ""))

        viewModel.getRoleListFromWebServices(
                GetRolesListRequest("", "", "", 1, ""))

        viewModel.saveUserRoleToWebServices(SaveUserRoleRequest(""))

        viewModel.saveUserUnitsToWebServices(SaveUserUnitsRequest(""))




        viewModel.updateDriverVehicleToWebServices(
                UpdateDriverVehicleRequest("", "", "", "",
                        1, ""))

        viewModel.updateCameraVehicleToWebServices(
                UpdateCameraVehicleRequest("", "", "", "",
                        "", "", 1, ""))




        viewModel.updateVehicleToWebServices(UpdateVehicleRequest(""))



        viewModel.getGroupUnitsInformationFromWebServices(
                GroupUnitsInformationRequest("", "", "",
                        2,
                        ""))

        viewModel.updateAccountGroupNameToWebServices(
                UpdateAccountGroupNameRequest("", "", "", "",
                        2, ""))

        viewModel.deleteAccountGroupFromWebServices(
                DeleteAccountGroupRequest("", "", "", 1, ""))

        viewModel.getUSerByIdFromWebServices(
                GetUserByIdRequest("", "", 1, ""))

        viewModel.changeUserPasswordFromWebServices(
                ChangeUserPasswordRequest("", "", "",
                        "", 1, ""))

        viewModel.getZoneListFromWebServices(
                ZoneListRequest("", "", 1, ""))

        viewModel.getUnitsTripsFromWebServices(
                UnitsTripsRequest("", "", 1, "", arrayListOf()))

        viewModel.getTripZonesFromWebServices(
                TripZonesRequest("", "", "", 1, ""))

        viewModel.startTripFromWebServices(
                StartTripRequest("", "", 1, "", arrayListOf()))

        viewModel.endTripFromWebServices(
                StartTripRequest("", "", 1, "", arrayListOf()))

        viewModel.addDestinationToWebServices(
                AddDestinationRequest(arrayListOf(), "", "", 1, ""))

        viewModel.deleteStartFromWebServices(
                DeleteStartRequest("", "", "", 1, ""))

        viewModel.deleteEndFromWebServices(
                DeleteStartRequest("", "", "", 1, ""))

        viewModel.deleteDestinationFromWebServices(
                DeleteStartRequest("", "", "", 1, ""))

        viewModel.updateDestinationFromWebServices(
                UpdateDestinationRequest("", true, "", "",
                        "", 1, ""))

        viewModel.getTagsListFromWebServices(
                GetTagsListRequest("", "", 1, ""))

    }


    override fun onLongClick(position: Repo) {

    }


    private fun initListenerForViewModel() {
        //AccountToken ----------------------------------------
        viewModel.getAccountEvent().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------EventByTags
        viewModel.getEventByTags().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

        //----------tagsDashboard
        viewModel.getTagsDashboard().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------tagsDashboard
        viewModel.addCamera().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------Camera List
        viewModel.getCameraList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateCamera
        viewModel.updateCameraStatus().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateCamera
        viewModel.deleteCamera().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateCamera
        viewModel.getCameraById().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateCamera
        viewModel.updateSilentMode().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getCommand
        viewModel.getCommand().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateCommand
        viewModel.updateCommand().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

        //----------addNewGeo
        viewModel.addNewGeo().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getGeoList
        viewModel.getGeoList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------deleteGeo
        viewModel.deleteGeo().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getActivities
        viewModel.getActivities().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getLastActivitiesTypes
        viewModel.getLastActivitiesTypes().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getLastActivities
        viewModel.getLastActivities().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getUserList
        viewModel.getUsersList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------addUser
        viewModel.addUSer().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------editUser
        viewModel.editUSer().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------editUser
        viewModel.deleteUSer().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getCategoryList
        viewModel.getCategoryList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getRoleList
        viewModel.getRoleList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------saveUserRole
        viewModel.saveUserRole().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------saveUserUnits
        viewModel.saveUserUnits().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })


        //----------updateDriveVehicle
        viewModel.updateDriverVehicle().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateDriveVehicle
        viewModel.updateCameraVehicle().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })


        //----------addAccountGroup
        viewModel.updateVehicle().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

        //----------groupUnitsInformation
        viewModel.groupUnitsInformation().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateAccountGroupName
        viewModel.updateAccountGroupName().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------deleteAccountGroupName
        viewModel.deleteAccountGroupName().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getUserByID
        viewModel.getUSerById().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------changeUserPassword
        viewModel.changeUserPassword().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getZoneList
        viewModel.getZoneList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getUnitsTrips
        viewModel.getUnitsTrips().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getTripZone
        viewModel.getTripZones().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

        //----------startTrip
        viewModel.startTrip().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------endTrip
        viewModel.endTrip().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------addDestination
        viewModel.addDestination().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------deleteStart
        viewModel.deleteStart().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------deleteEnd
        viewModel.deleteEnd().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------deleteDestination
        viewModel.deleteDestination().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------updateDestination
        viewModel.updateDestination().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
        //----------getTagsList
        viewModel.getTagsList().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

    }

}


