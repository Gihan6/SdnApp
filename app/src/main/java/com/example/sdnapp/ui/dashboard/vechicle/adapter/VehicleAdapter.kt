package com.example.sdnapp.ui.dashboard.vechicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_vehicle.view.*


class VehicleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        GenericRecyclerViewAdapter<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener,
                VehicleAdapter.BenefitsViewHolder>(context, listener) {

    lateinit var groupsAdapter: GroupsAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(itemView: View, private val listener: OnRecyclerItemClickListener) :
            BaseViewHolder<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener>(itemView, listener), View.OnClickListener {

        init {
            groupsAdapter = GroupsAdapter(
                    itemView.context,
                    OnRecyclerItemClickListener {

                    })
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: GetVehicleListResponse.Vehicle) {

            itemView.tv_singleLayoutVehicle_vehicleName.text = item.vehicle_name
            itemView.tv_singleLayoutVehicle_plate.text = item.plate_no
            itemView.tv_singleLayoutVehicle_startDate.text = "License start :"+item.license_start
            itemView.tv_singleLayoutVehicle_endDate.text = "License end :"+item.license_end
            itemView.tv_singleLayoutVehicle_mileAge.text = "mileAge :"+item.current_mileage.toString()

            if (item.groups != null && item.groups.isNotEmpty()) {
                itemView.rv_singleLayoutVehicle_groups.apply {
                    layoutManager = LinearLayoutManager(context)
                    (layoutManager as LinearLayoutManager).orientation =
                        LinearLayoutManager.HORIZONTAL
                    itemView.rv_singleLayoutVehicle_groups.layoutManager = layoutManager
                    adapter = groupsAdapter
                }
                groupsAdapter.items = item.groups

            }
        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}