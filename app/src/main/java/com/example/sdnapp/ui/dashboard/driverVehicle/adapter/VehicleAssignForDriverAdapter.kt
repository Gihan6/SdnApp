package com.example.sdnapp.ui.dashboard.driverVehicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_assign_vehicle.view.*

class VehicleAssignForDriverAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener,
            VehicleAssignForDriverAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_assign_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener>(
            itemView,
            listener
        ),
        View.OnClickListener {

        init {
            itemView.rb_singleLayoutAssignVehicle_vehicle.setOnClickListener(this)
        }

        override fun onBind(item: GetVehicleListResponse.Vehicle) {
            if (item.vehicle_name != null) {
                itemView.rb_singleLayoutAssignVehicle_vehicle.text = item.vehicle_name
            }
            itemView.rb_singleLayoutAssignVehicle_vehicle.isChecked = item.select

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}