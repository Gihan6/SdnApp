package com.example.sdnapp.ui.dashboard.driverVehicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_driver_vehicle.view.*

class DriverVehicleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<GetDriverListResponse.Driver, OnRecyclerItemClickListener,
            DriverVehicleAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_driver_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<GetDriverListResponse.Driver, OnRecyclerItemClickListener>(
            itemView,
            listener
        ),
        View.OnClickListener {

        init {

            itemView.iv_singleLayoutDiverVehicle_edit.setOnClickListener(this)
        }

        override fun onBind(item: GetDriverListResponse.Driver) {
            itemView.tv_singleLayoutDiverVehicle_driverName.setText(item.driver_name)
            itemView.tv_singleLayoutDiverVehicle_linkedVehicle.setText(item.vehicle_name)
            itemView.tv_singleLayoutDiverVehicle_plate.setText(item.plate_no)


        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}