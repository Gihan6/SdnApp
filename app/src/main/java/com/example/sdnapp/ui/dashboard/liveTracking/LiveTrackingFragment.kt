package com.example.sdnapp.ui.dashboard.liveTracking

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.service.TrackingService
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.liveTracking.adapter.LiveVehicleAdapter
import com.example.sdnapp.ui.dashboard.liveTracking.adapter.SpinnerGroupAdapter
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Constants.ACTION_PAUSE_SERVICE
import com.example.sdnapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.sdnapp.util.Constants.ACTION_STOP_SERVICE
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.fragment_live.*
import org.koin.android.ext.android.inject


class LiveTrackingFragment : BaseFragment() {
    private val viewModel by inject<VehicleViewModel>()
    private val liveTrackingViewModel by inject<LiveTrackViewModel>()
    private var isTracking = false
    private var isServiceOn = false
    private lateinit var liveVehicleAdapter: LiveVehicleAdapter
    private var vehicleList = mutableListOf<GetVehicleListResponse.Vehicle>()
    private var filterData = mutableListOf<GetVehicleListResponse.Vehicle>()
    private lateinit var spinnerGroupAdapter: SpinnerGroupAdapter
    var groupList = mutableListOf<AccountGroupsResponse.Group>()
    private var selectedGroupIds = mutableListOf<String>()

    companion object {
        var selectedVehicleIds = mutableListOf<GetVehicleListResponse.Vehicle>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
        initAdapter()
        initViewModel()
        selectAll()
        getConnectionStatusFromWebservice()
        getVehicleFromWebServices()
        getGroups()
        btnLive.setOnClickListener {
            if (isTracking) {
                isServiceOn = false
                sendCommandToService(ACTION_PAUSE_SERVICE)
            } else {
                if (selectedGroupIds.isNotEmpty() && selectedVehicleIds.isNotEmpty()) {
                    isServiceOn = true
                    sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
                } else
                    Toast.makeText(context, "please select group and vehicle", Toast.LENGTH_LONG)
                        .show()
            }

        }


    }

    private fun sendCommandToService(action: String) =
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    private fun selectAll() {
        cb_liveTrackingFragment_selectAll.setOnClickListener {
            if (cb_liveTrackingFragment_selectAll.isChecked) {
                for (v in filterData) {
                    v.select = true
                    selectedVehicleIds.add(v)
                }
                cb_liveTrackingFragment_selectAll.isSelected = false
            } else {

                for (v in filterData) {
                    v.select = false
                    selectedVehicleIds.clear()
                }
                cb_liveTrackingFragment_selectAll.isSelected = true


            }
            setAVehicleAdapter(filterData)
        }
    }


    private fun getConnectionStatusFromWebservice() {
        liveTrackingViewModel.getConnectionStatusFromWebServices()
    }

    private fun setAVehicleAdapter(data: List<GetVehicleListResponse.Vehicle>) {
        rv_liveTrackingFragment_vehicle.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_liveTrackingFragment_vehicle.layoutManager = layoutManager
            adapter = liveVehicleAdapter
        }
        liveVehicleAdapter.items = data
    }

    private fun initAdapter() {
        liveVehicleAdapter = LiveVehicleAdapter(
            requireContext()
        ) {

            showDialog(vehicleList[it])
        }
    }

    private fun initSpinner() {
        groupList.add(AccountGroupsResponse.Group("-1", "Select Group", "", "", emptyList()))
        spinnerGroupAdapter = SpinnerGroupAdapter(requireContext(), groupList)
        sp_liveTrackingFragment_groups.adapter = spinnerGroupAdapter

        sp_liveTrackingFragment_groups.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedVehicleIds.clear()
                    filterData.clear()
                    if (groupList[position].groupid != "-1") {
                        selectedGroupIds.add(groupList[position].groupid)
                        for (v in vehicleList) {
                            if (!v.groups.isNullOrEmpty()) {
                                if (v.groups[0].groupid == groupList[position].groupid) {
                                    filterData.add(v)
                                }
                            }
                        }
                        setAVehicleAdapter(filterData)
                    } else {
                        filterData = vehicleList
                        setAVehicleAdapter(filterData)
                    }
                }
            }
    }

    private fun getVehicleFromWebServices() {
        viewModel.getVehicleListFromWebServices()
    }

    private fun getGroups() {
        viewModel.accountGroupsFromWebServices()

    }

    private fun initViewModel() {
        liveTrackingViewModel.getConnectionStatus().observe(requireActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        if (it.data?.connectionStatus != null) {
                            tv_liveTrackingFragment_online.text =
                                it.data.connectionStatus[0].online.toString()
                            tv_liveTrackingFragment_offline.text =
                                it.data.connectionStatus[0].offline.toString()

                        } else {
                            showToast(requireContext(), it.data!!.type)

                        }
                    }
                    Status.ERROR -> {
                        it.message?.let { it1 -> showToast(requireContext(), it1) }
                    }

                }
            }
        })

        viewModel.getVehicleList().observe(requireActivity(), {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        showLoading()
                    }
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (!it.data!!.Vehicles.isNullOrEmpty()) {
                            vehicleList = it.data.Vehicles.toMutableList()
                            filterData = it.data.Vehicles.toMutableList()
                            setAVehicleAdapter(filterData)
                        }

                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(requireContext(), it1) }

                    }

                }
            }
        })
        viewModel.accountGroups().observe(requireActivity(), {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        if (!it.data!!.groups.isNullOrEmpty()) {
                            for (i in it.data.groups) {
                                groupList.add(i)
                            }
                            sp_liveTrackingFragment_groups.adapter = spinnerGroupAdapter

                        }


                    }
                    Status.ERROR -> {
                        it.message?.let { it1 -> showToast(requireContext(), it1) }
                    }
                    Status.LOADING -> {
                    }
                }

            }
        })

    }

    private fun showDialog(data: GetVehicleListResponse.Vehicle) {
        val ft = parentFragmentManager.beginTransaction()
        val newFragment = DialogFragmentForVehicleDetail(data)
        newFragment.show(ft, "dialog")
    }

    override fun onDestroy() {
        if (isServiceOn)
            sendCommandToService(ACTION_STOP_SERVICE)
        selectedVehicleIds.clear()
        super.onDestroy()
    }
}