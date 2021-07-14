package com.example.sdnapp.ui.dashboard.groups.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_main_group.view.*

class MainGroupsAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        GenericRecyclerViewAdapter<AccountGroupsResponse.Group, OnRecyclerItemClickListener,
                MainGroupsAdapter.BenefitsViewHolder>(context, listener) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_main_group, parent), listener)
    }


    inner class BenefitsViewHolder(
            itemView: View,
            private val listener: OnRecyclerItemClickListener
    ) :
            BaseViewHolder<AccountGroupsResponse.Group, OnRecyclerItemClickListener>(itemView, listener),
            View.OnClickListener {

        init {

            itemView.setOnClickListener(this)
        }

        override fun onBind(item: AccountGroupsResponse.Group) {
            itemView.tv_fragmentGroup_groupName.setText(item.group_name)
            if (!item.units.isNullOrEmpty())
                itemView.tv_fragmentGroup_memberNumber.setText(item.units.size.toString())


        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}