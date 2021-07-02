package com.example.sdnapp.ui.dashboard.driverVehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.driverVehicle.adapter.DriverVehicleAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_driver_vehicle.*
import org.koin.android.ext.android.inject

class DriverVehicleFragment : BaseFragment() {

    private val viewModel by inject<DriverVehicleViewModel>()
    lateinit var driverVehicleAdapter: DriverVehicleAdapter

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
        var data = mutableListOf<String>()
        data.add("")
        data.add("")
        data.add("")
        data.add("")
        setAdapter(data)
    }
    private fun initAdapter() {

        driverVehicleAdapter = DriverVehicleAdapter(
            requireContext(),
            OnRecyclerItemClickListener {

            })

    }

    private fun setAdapter(data: List<String>) {
        rv_driverVehicle_driverVehicle.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_driverVehicle_driverVehicle.layoutManager = layoutManager
            adapter = driverVehicleAdapter
        }
        driverVehicleAdapter.items = data


    }

    private fun getDataFromWebservices() {


    }

    private fun initViewModel() {
    }

}