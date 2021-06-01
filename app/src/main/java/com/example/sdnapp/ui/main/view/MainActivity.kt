package com.example.sdnapp.ui.main.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.db.Repo
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.main.adapter.ListenerAdapter
import com.example.sdnapp.ui.main.adapter.MainAdapter
import com.example.sdnapp.ui.main.viewModel.MainViewModel
import com.example.sdnapp.util.Status
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(), ListenerAdapter {

    private val viewModel by inject<MainViewModel>()
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        viewModel.getSessionTokenFromWebServices(
                SessionTokenRequest("", "", true))

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
                        "", 1,"")
        )
        viewModel.sendCommandToWebServices(
                SendCommandRequest("", "", "",
                        "", "", 1,"")
        )
        viewModel.getCommandFromWebServices(
                GetCommandRequest("", "", "",
                        "", 1,"")
        )
        viewModel.updateCommandFromWebServices(UpdateCommandRequest(""))

        viewModel.addUserToWebServices(AddUserRequest(
                "", "", "", "", true,
                true, "", "", "", "",
                "", 1,""))

        viewModel.editUserToWebServices(EditUserRequest(
                "", "", "", true,
                true, "", "", "", "",
                1,""))
        viewModel.deleteUserFromWebServices(DeleteUserRequest(
                "", "", "", "", 1,""))

        viewModel.getCategoryListFromWebServices(
                GetCategoryListRequest("", "", 1, ""))

        viewModel.getRoleListFromWebServices(
                GetRolesListRequest("", "", "", 1, ""))

        viewModel.saveUserRoleToWebServices(SaveUserRoleRequest(""))

        viewModel.saveUserUnitsToWebServices(SaveUserUnitsRequest(""))

        viewModel.getVehicleListFromWebServices(
                GetVehicleListRequest("", "", 1, ""))

        viewModel.getDriverListFromWebServices(
                GetDriverListRequest("", "", 1, ""))

        viewModel.addDriverToWebServices(
                AddDriverRequest("", "", "", "",
                        "", "", "", 1, ""))

        viewModel.addVehicleToWebServices(
                AddVehicleRequest("", "", "", "",
                        "", "", 1, ""))

        viewModel.updateDriverVehicleToWebServices(
                UpdateDriverVehicleRequest("", "", "", "",
                        1, ""))

        viewModel.updateCameraVehicleToWebServices(
                UpdateCameraVehicleRequest("", "", "", "",
                        "", "", 1, ""))

        viewModel.accountGroupsFromWebServices(
                AccountGroupsRequest("", "", 1, ""))

        viewModel.addAccountGroupsFromWebServices(
                AddAccountGroupsRequest("", "", "",
                        "", 1, ""))

        viewModel.updateVehicleToWebServices(UpdateVehicleRequest(""))

        viewModel.updateDriverToWebServices(
                UpdateDriverRequest("", "", "",
                        "", "", "", "", "", 2,
                        ""))

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
    }


    override fun onLongClick(position: Repo) {

    }


    private fun initListenerForViewModel() {
        //sessionToken----------------------------------------
        viewModel.getSessionToken().observe(this, Observer {
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
        //----------saveUserUnits
        viewModel.getVehicleList().observe(this, Observer {
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
        viewModel.getDriverList().observe(this, Observer {
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

        //----------addDriver
        viewModel.addDriver().observe(this, Observer {
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
        //----------addVehicle
        viewModel.addVehicle().observe(this, Observer {
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
        //----------accountGroups
        viewModel.accountGroups().observe(this, Observer {
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
        viewModel.addAccountGroups().observe(this, Observer {
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
        //----------Update Driver
        viewModel.updateDriver().observe(this, Observer {
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
    }

}


