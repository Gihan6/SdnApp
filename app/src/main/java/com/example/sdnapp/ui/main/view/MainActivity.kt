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
        viewModel.getSessionTokenFromWebServices(SessionTokenRequest("", "", true))
        viewModel.getAccountEventFromWebServices(
                AccountEventRequest(
                        "",
                        "", "", "", "", ""
                )
        )

        viewModel.getEventByTagsFromWebServices(
                EventsByTagsRequest(
                        "",
                        "", "", "", ""
                )
        )
        viewModel.getTagsDashboardFromWebServices(
                TagsDashboardRequest("", "", "")
        )
        viewModel.addCameraToWebServices(
                AddCameraRequest("", "", "", "", "",
                        "")
        )
        viewModel.getCameraListFromWebServices(
                CameraListRequest("", "", "")
        )
        viewModel.updateCameraFromWebServices(
                UpdateCameraRequest("", "", "", "",
                        "")
        )
        viewModel.deleteCameraFromWebServices(
                DeleteCameraRequest("", "", "", "")
        )
        viewModel.getCameraByIdFromWebServices(
                CameraByIdRequest("", "", "", "")
        )
        viewModel.updateSilentModeFromWebServices(
                UpdateSilentModeRequest("", true, "",
                        "", "")
        )
        viewModel.sendCommandToWebServices(
                SendCommandRequest("", "", "",
                        "", "", 1)
        )
        viewModel.getCommandFromWebServices(
                GetCommandRequest("", "", "",
                        "", "")
        )
        viewModel.updateCommandFromWebServices(UpdateCommandRequest())
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
    }

}


