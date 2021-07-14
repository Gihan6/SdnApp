package com.example.sdnapp.ui.dashboard.driverVehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.dashboard.driverVehicle.adapter.VehicleAssignForDriverAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.assign_vehicle_to_driver_dialog.*
import okhttp3.internal.notify

class AssignVehicleToDriverDialog(private val data: List<GetVehicleListResponse.Vehicle>) :
    DialogFragment() {
    private lateinit var vehicleAssignForDriverAdapter:VehicleAssignForDriverAdapter
    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.assign_vehicle_to_driver_dialog, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
         vehicleAssignForDriverAdapter = VehicleAssignForDriverAdapter(
            requireContext(),
            OnRecyclerItemClickListener {

                data[it].select = true
                for (v in data) {
                    if (v.vehicleid != data[it].vehicleid) {
                        v.select = false
                    }

                }
                vehicleAssignForDriverAdapter.notifyDataSetChanged()




            })

        rv_assignVehicleToDriverDialog_vehicles.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_assignVehicleToDriverDialog_vehicles.layoutManager = layoutManager
            adapter = vehicleAssignForDriverAdapter
        }

        vehicleAssignForDriverAdapter.items = data
        btn_assignVehicleToDriverDialog_cancel.setOnClickListener {
            dismiss()
        }
        btn_assignVehicleToDriverDialog_save.setOnClickListener {
            dismiss()
        }
    }


}
