package com.example.sdnapp.ui.dashboard.liveTracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AccountGroupsRequest
import com.example.sdnapp.data.networkModels.request.GetConnectionStatusRequest
import com.example.sdnapp.data.networkModels.request.GetVehicleListRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.db.Repo
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()

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
      //  initSpinner()
        initAdapter()
        var data = mutableListOf<String>()
        data.add("")
        data.add("")
        data.add("")
        setAVehicleAdapter(data)
        getConnectionStatusFromWebservice()
        getDataFromWebServices()
        getGroups()

    }

    private fun getGroups() {
        viewModel.accountGroupsFromWebServices(
            AccountGroupsRequest()
        )

    }

    private fun getConnectionStatusFromWebservice() {
        liveTrackingViewModel.getConnectionStatusFromWebServices(GetConnectionStatusRequest())
    }

    private fun setAVehicleAdapter(data: List<String>) {
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
            requireContext(),
            OnRecyclerItemClickListener {

                showDialog()
            })
    }

    private fun initSpinner(groups: MutableList<AccountGroupsResponse.Group>) {
        var modelList = mutableListOf<AccountGroupsResponse.Group>()
        //  modelList.add("Group")
        var spinnerGroupAdapter = SpinnerGroupAdapter(requireContext(), groups)
        sp_liveTrackingFragment_groups.adapter = spinnerGroupAdapter
    }

    private fun getDataFromWebServices() {
        viewModel.getVehicleListFromWebServices(GetVehicleListRequest())
    }

    private fun initViewModel() {
        liveTrackingViewModel.getConnectionStatus().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        showLoading()
                    }
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (it.data?.data != null) {
                            tv_liveTrackingFragment_online.setText(it.data.data[0].online)
                            tv_liveTrackingFragment_offline.setText(it.data.data[0].offline)

                        } else {
                            showToast(requireContext(), it.data!!.type)

                        }
                    }
                    Status.ERROR -> {

                        it.message?.let { it1 -> showToast(requireContext(), it1) }
//                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
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
                        dismissLoading()
                        if (!it.data!!.data.isNullOrEmpty())
                            initSpinner(it.data.data as MutableList<AccountGroupsResponse.Group>)
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(requireContext(), it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }

            }
        })
    }

    private fun showDialog() {

        val ft = fragmentManager?.beginTransaction()
        val newFragment = DialogFragmentForVehicleDetail(Repo(1, "", ""))
        newFragment.show(ft!!, "dialog")
    }

}