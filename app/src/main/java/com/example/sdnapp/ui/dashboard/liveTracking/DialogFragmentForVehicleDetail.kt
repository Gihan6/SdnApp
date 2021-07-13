package com.example.sdnapp.ui.dashboard.liveTracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import kotlinx.android.synthetic.main.dialog_vehicle_detail.*

class DialogFragmentForVehicleDetail(private val data: GetVehicleListResponse.Vehicle) :
    DialogFragment() {

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
        return inflater.inflate(R.layout.dialog_vehicle_detail, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        tv_dialogVehicleDetail_name.text = data.driver_name
        tv_dialogVehicleDetail_id.text = data.driverid
        tv_dialogVehicleDetail_lastDate.text = data.last_location
        tv_dialogVehicleDetail_speed.text = data.max_speed
        tv_dialogVehicleDetail_deviceMileAge.text = data.current_mileage.toString()
        tv_dialogVehicleDetail_sdnMileAge.text = data.vehicle_current_mileage.toString()
        tv_dialogVehicleDetail_fuel.text = data.fuel_fr

        btn_dialogVehicleDetail_cancel.setOnClickListener {
            dismiss()
        }
    }


}
