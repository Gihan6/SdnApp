package com.example.sdnapp.ui.dashboard.vechicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_vehicle.view.*


class VehicleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        GenericRecyclerViewAdapter<String, OnRecyclerItemClickListener,
                VehicleAdapter.BenefitsViewHolder>(context, listener) {

    lateinit var groupsAdapter: GroupsAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(itemView: View, private val listener: OnRecyclerItemClickListener) :
            BaseViewHolder<String, OnRecyclerItemClickListener>(itemView, listener), View.OnClickListener {

        init {
            groupsAdapter = GroupsAdapter(
                    itemView.context,
                    OnRecyclerItemClickListener {

                    })
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: String) {
//            Glide.with(itemView.iv_icon.context).load(item).into(itemView.iv_icon)

            var data = mutableListOf<String>()
            data.add("")
            data.add("")
            data.add("")

            itemView.rv_singleLayoutVehicle_groups.apply {
                layoutManager = LinearLayoutManager(context)
                (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                itemView.rv_singleLayoutVehicle_groups.layoutManager = layoutManager
                adapter = groupsAdapter
            }
            groupsAdapter.items = data


        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}