package com.example.sdnapp.ui.dashboard.driverVehicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener

class DriverVehicleAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<String, OnRecyclerItemClickListener,
            DriverVehicleAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_driver_vehicle, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<String, OnRecyclerItemClickListener>(itemView, listener),
        View.OnClickListener {

        init {

            itemView.setOnClickListener(this)
        }

        override fun onBind(item: String) {

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}