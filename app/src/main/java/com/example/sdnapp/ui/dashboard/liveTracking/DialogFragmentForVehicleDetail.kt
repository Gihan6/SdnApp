package com.example.sdnapp.ui.dashboard.liveTracking

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.db.Repo

class DialogFragmentForVehicleDetail(private val data: GetVehicleListResponse.Vehicle) : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

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
        val view = inflater.inflate(R.layout.dialog_vehicle_detail, null, false)
        setupView(view)


        return view
    }

    private fun setupView(view: View) {
        val name = view.findViewById(R.id.tv_dialogVehicleDetail_name) as TextView
        val id = view.findViewById(R.id.tv_dialogVehicleDetail_id) as TextView
        val lastDate = view.findViewById(R.id.tv_dialogVehicleDetail_lastDate) as TextView
        val speed = view.findViewById(R.id.tv_dialogVehicleDetail_speed) as TextView
        val mileAge = view.findViewById(R.id.tv_dialogVehicleDetail_deviceMileAge) as TextView
        val sdnMileAge = view.findViewById(R.id.tv_dialogVehicleDetail_sdnMileAge) as TextView
        val fuel = view.findViewById(R.id.tv_dialogVehicleDetail_fuel) as TextView

        val cancel = view.findViewById(R.id.btn_dialogVehicleDetail_cancel) as TextView


        name.text=data.driver_name
        id.text=data.driverid
        lastDate.text=data.last_update
        speed.text=data.max_speed
        mileAge.text=data.current_mileage.toString()
        sdnMileAge.text=data.vehicle_current_mileage.toString()
        fuel.text=data.fuel_fr

        cancel.setOnClickListener {
            dismiss()
        }
    }



}
