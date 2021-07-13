package com.example.sdnapp.ui.dashboard.liveTracking.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.dashboard.liveTracking.LiveTrackingFragment
import com.example.sdnapp.ui.dashboard.vechicle.adapter.GroupsAdapter
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_life_vehicle.view.*


class LiveVehicleAdapter (context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener,
            LiveVehicleAdapter.BenefitsViewHolder>(context, listener) {

    lateinit var groupsAdapter: GroupsAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_life_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<GetVehicleListResponse.Vehicle, OnRecyclerItemClickListener>(itemView, listener),
        View.OnClickListener {

        init {
            groupsAdapter = GroupsAdapter(
                itemView.context,
                {

                })
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: GetVehicleListResponse.Vehicle) {


            itemView.tv_singleLayoutLifeVehicle_plate.text=item.vehicle_name
            if (item.vehicleAccOn) {
                itemView.tv_singleLayoutLifeVehicle_status.text = "ON"
            }else{
                itemView.tv_singleLayoutLifeVehicle_status.text = "OFF"

            }
            itemView.cb_singleLayoutLifeVehicle_selectVehicle.setOnClickListener { view ->
                if ((view as CompoundButton).isChecked) {
                    LiveTrackingFragment.selectedVehicleIds.add(item)
                    println("Checked")
                } else {
                    var vehicle: GetVehicleListResponse.Vehicle? = LiveTrackingFragment.selectedVehicleIds.find { it.vehicleid==item.vehicleid }
                    LiveTrackingFragment.selectedVehicleIds.remove(vehicle)
                    println("Un-Checked")
                }
            }

            itemView.cb_singleLayoutLifeVehicle_selectVehicle.isChecked=item.select

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}