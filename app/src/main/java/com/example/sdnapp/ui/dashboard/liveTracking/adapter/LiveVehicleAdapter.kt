package com.example.sdnapp.ui.dashboard.liveTracking.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.ui.dashboard.vechicle.adapter.GroupsAdapter
import com.example.sdnapp.ui.dashboard.vechicle.adapter.VehicleAdapter
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_life_vehicle.view.*
import kotlinx.android.synthetic.main.single_layout_vehicle.view.*

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
                OnRecyclerItemClickListener {

                })
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: GetVehicleListResponse.Vehicle) {


            itemView.tv_singleLayoutLifeVehicle_plate.text=item.plate_no
            if (item.vehicleAccOn) {
                itemView.tv_singleLayoutLifeVehicle_status.text = "ON"
            }else{
                itemView.tv_singleLayoutLifeVehicle_status.text = "OFF"

            }
            itemView.cb_singleLayoutLifeVehicle_selectVehicle.isChecked=item.select

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}