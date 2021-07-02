package com.example.sdnapp.ui.dashboard.vechicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener

class GroupsAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<String, OnRecyclerItemClickListener,
            GroupsAdapter.BenefitsViewHolder>(context, listener) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_vehicle_group, parent), listener)
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
//            Glide.with(itemView.iv_icon.context).load(item).into(itemView.iv_icon)

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}