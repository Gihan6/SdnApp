package com.example.sdnapp.ui.dashboard.vechicle.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
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
    var vehicleList = mutableListOf<GetVehicleListResponse.Vehicle>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vehicle, container, false)
    }

    override fun onStart() {
        super.onStart()
        getVehicleFromWebServices()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAdapter()
        addVehicle()
        search()

    }

    private fun search() {
        et_vehicleFragment_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!vehicleList.isNullOrEmpty() && s != null) {
                    var searchList = vehicleList.filter {
                        it.vehicle_name.contains(s)
                    }
                    if (!searchList.isNullOrEmpty()) {
                        setAdapter(searchList)
                    }
                }else if (s == null||s.isEmpty())
                {
                    setAdapter(vehicleList)
                }
            }
        })
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

    private fun setAdapter(data: List<GetVehicleListResponse.Vehicle>) {
        rv_vehicleFragment_vehicles.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_vehicleFragment_vehicles.layoutManager = layoutManager
            adapter = vehicleAdapter
        }
        vehicleAdapter.items = data


    }

    private fun getVehicleFromWebServices() {
        viewModel.getVehicleListFromWebServices()
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
                        if (!it.data!!.Vehicles.isNullOrEmpty()) {
                            setAdapter(it.data!!.Vehicles)
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