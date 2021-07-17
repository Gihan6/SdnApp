package com.example.sdnapp.ui.dashboard.driverVehicle

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.driver.DriverViewModel
import com.example.sdnapp.ui.dashboard.driverVehicle.adapter.DriverVehicleAdapter
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_driver_vehicle.*
import org.koin.android.ext.android.inject

class DriverVehicleFragment : BaseFragment() {

    private val viewModel by inject<DriverVehicleViewModel>()
    private val vehicleViewModel by inject<VehicleViewModel>()
    private val driverViewModel by inject<DriverViewModel>()

    lateinit var driverVehicleAdapter: DriverVehicleAdapter
    private var driverList = mutableListOf<GetDriverListResponse.Driver>()
    private var vehicleList = mutableListOf<GetVehicleListResponse.Vehicle>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_driver_vehicle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModel()
        getVehicleFromWebServices()
        getDriverFromWebservices()

        search()
    }

    private fun search() {
        et_driverVehicle_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!driverList.isNullOrEmpty() && s != null) {
                    var searchList = driverList.filter {
                        it.driver_name.contains(s)
                    }
                    if (!searchList.isNullOrEmpty()) {
                        setAdapter(searchList)
                    }
                } else if (s == null || s.isEmpty()) {
                    setAdapter(driverList)
                }
            }
        })
    }

    private fun getVehicleFromWebServices() {
        vehicleViewModel.getVehicleListFromWebServices()
    }

    private fun getDriverFromWebservices() {
        driverViewModel.getDriverListFromWebServices()

    }

    private fun initAdapter() {

        driverVehicleAdapter = DriverVehicleAdapter(
                requireContext(),
                OnRecyclerItemClickListener {

                    if (!vehicleList.isNullOrEmpty()) {


                        var unReservedVehicle = vehicleList.filter {
                            it.driver_name == null
                        }
                        if (!unReservedVehicle.isNullOrEmpty())
                            showDialog(unReservedVehicle)
                    }

                })

    }

    private fun showDialog(data: List<GetVehicleListResponse.Vehicle>) {
        val ft = parentFragmentManager.beginTransaction()
        val newFragment = AssignVehicleToDriverDialog(data)
        newFragment.setMigrateCallback(object : AssignVehicleToDriverDialog.MigrateCallback {
            override fun onConfirmClick(selectVehicle: GetVehicleListResponse.Vehicle) {

                //pos of vehicle
                Toast.makeText(context, selectVehicle.vehicle_name, Toast.LENGTH_SHORT).show()
                newFragment.dismiss()

            }
        })
        newFragment.show(ft, "dialog")
    }

    private fun setAdapter(data: List<GetDriverListResponse.Driver>) {
        rv_driverVehicle_driverVehicle.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_driverVehicle_driverVehicle.layoutManager = layoutManager
            adapter = driverVehicleAdapter
        }
        driverVehicleAdapter.items = data


    }



    private fun initViewModel() {
        driverViewModel.getDriverList().observe(requireActivity(), Observer {
            it?.let { resource ->

                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (it.data!!.drivers != null) {
                            setAdapter(it.data.drivers)
                            driverList =
                                it.data.drivers as MutableList<GetDriverListResponse.Driver>
                        }
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

        vehicleViewModel.getVehicleList().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {

                    }
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (!it.data!!.Vehicles.isNullOrEmpty()) {
//                            setAdapter(it.data!!.Vehicles)
                            vehicleList =
                                it.data!!.Vehicles as MutableList<GetVehicleListResponse.Vehicle>
                        }


                    }
                    Status.ERROR -> {
                        it.message?.let { it1 -> showToast(requireContext(), it1) }

                    }

                }
            }
        })
    }

}