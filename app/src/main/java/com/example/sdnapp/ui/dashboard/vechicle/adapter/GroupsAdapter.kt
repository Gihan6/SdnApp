package com.example.sdnapp.ui.dashboard.vechicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_vehicle_group.view.*

class GroupsAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<GetVehicleListResponse.Group, OnRecyclerItemClickListener,
            GroupsAdapter.BenefitsViewHolder>(context, listener) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_vehicle_group, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<GetVehicleListResponse.Group, OnRecyclerItemClickListener>(itemView, listener),
        View.OnClickListener {

        init {

            itemView.setOnClickListener(this)
        }

        override fun onBind(item: GetVehicleListResponse.Group) {

            itemView.tv_singleLayoutVehicleGroup_groupName.text=item.group_name
        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}