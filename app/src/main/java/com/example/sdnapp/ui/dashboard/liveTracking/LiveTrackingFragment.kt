package com.example.sdnapp.ui.dashboard.liveTracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.GetConnectionStatusRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.liveTracking.adapter.LiveVehicleAdapter
import com.example.sdnapp.ui.dashboard.liveTracking.adapter.SpinnerGroupAdapter
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_live.*
import org.koin.android.ext.android.inject


class LiveFragment : BaseFragment() {
    private val viewModel by inject<VehicleViewModel>()
    private val liveTrackingViewModel by inject<LiveTrackViewModel>()

    lateinit var liveVehicleAdapter: LiveVehicleAdapter
    var vehicleList = mutableListOf<GetVehicleListResponse.Vehicle>()
    var filterData = mutableListOf<GetVehicleListResponse.Vehicle>()

    lateinit var spinnerGroupAdapter: SpinnerGroupAdapter
    var grouplList = mutableListOf<AccountGroupsResponse.Group>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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

    }

    private fun selectAll() {
        cb_liveTrackingFragment_selectAll.setOnClickListener {
            if (cb_liveTrackingFragment_selectAll.isChecked) {
                for (v in filterData) {
                    v.select = true
                }
                cb_liveTrackingFragment_selectAll.isSelected = false
            } else {

                for (v in filterData) {
                    v.select = false
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
        if (data != null) {
            rv_liveTrackingFragment_vehicle.apply {
                layoutManager = LinearLayoutManager(context)
                (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
                rv_liveTrackingFragment_vehicle.layoutManager = layoutManager
                adapter = liveVehicleAdapter
            }
            liveVehicleAdapter.items = data
        }
    }

    private fun initAdapter() {
        liveVehicleAdapter = LiveVehicleAdapter(
                requireContext(),
                OnRecyclerItemClickListener {

                    showDialog(vehicleList[it])
                })
    }

    private fun initSpinner() {
        grouplList.add(AccountGroupsResponse.Group("-1", "Group", "", "", emptyList()))

        spinnerGroupAdapter = SpinnerGroupAdapter(requireContext(), grouplList)
        sp_liveTrackingFragment_groups.adapter = spinnerGroupAdapter

        sp_liveTrackingFragment_groups.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                filterData.clear()
                if (grouplList[position].groupid != "-1") {

                    for (v in vehicleList) {
                        if (!v.groups.isNullOrEmpty()) {
                            if (v.groups[0].groupid == grouplList[position].groupid) {
                                filterData.add(v)
                            }
                        }
                    }
                    setAVehicleAdapter(filterData)
                } else {
                    filterData=vehicleList
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
        liveTrackingViewModel.getConnectionStatus().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        if (it.data?.connectionStatus != null) {
                            tv_liveTrackingFragment_online.setText(it.data.connectionStatus[0].online.toString())
                            tv_liveTrackingFragment_offline.setText(it.data.connectionStatus[0].offline.toString())

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

        viewModel.getVehicleList().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        showLoading()
                    }
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (!it.data!!.Vehicles.isNullOrEmpty()) {
                            vehicleList = it.data.Vehicles.toMutableList()
                            filterData= it.data.Vehicles.toMutableList()
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
        viewModel.accountGroups().observe(requireActivity(), androidx.lifecycle.Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        if (!it.data!!.groups.isNullOrEmpty()) {
                            for (i in it.data!!.groups) {
                                grouplList.add(i)
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

        val ft = fragmentManager?.beginTransaction()
        val newFragment = DialogFragmentForVehicleDetail(data)
        newFragment.show(ft!!, "dialog")
    }

}