package com.example.sdnapp.ui.dashboard.vechicle.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.GetVehicleListRequest
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.vechicle.adapter.VehicleAdapter
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_vehicle.*
import org.koin.android.ext.android.inject

class VehicleFragment : BaseFragment() {

    private val viewModel by inject<VehicleViewModel>()
    lateinit var vehicleAdapter: VehicleAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vehicle, container, false)
    }

    override fun onStart() {
        super.onStart()
        getDataFromWebServices()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAdapter()
        addVehicle()

    }

    private fun addVehicle() {
        btn_vehicleFragment_addVehicle.setOnClickListener(View.OnClickListener {
            var intent = Intent(requireContext(), AddVehiclesActivity::class.java)
            startActivity(intent)

        })
    }

    private fun initAdapter() {

        vehicleAdapter = VehicleAdapter(
                requireContext(),
                OnRecyclerItemClickListener {

                })

    }

    private fun setAdapter(data: List<GetVehicleListResponse.Data>) {
        rv_vehicleFragment_vehicles.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_vehicleFragment_vehicles.layoutManager = layoutManager
            adapter = vehicleAdapter
        }
        vehicleAdapter.items = data


    }

    private fun getDataFromWebServices() {
        viewModel.getVehicleListFromWebServices(
                GetVehicleListRequest())
    }

    private fun initViewModel() {

        viewModel.getVehicleList().observe(requireActivity(), Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        showLoading()
                    }
                    Status.SUCCESS -> {
                        dismissLoading()
                        if(!it.data!!.data.isNullOrEmpty()){
                            setAdapter(it.data!!.data)
                        }


                    }
                    Status.ERROR -> {

//                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })
    }

}