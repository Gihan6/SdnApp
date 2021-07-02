package com.example.sdnapp.ui.dashboard.vechicle.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_group_dialog.view.*

class DialogGroupsAdapter(context: Context, listener: OnRecyclerItemClickListener) :
    GenericRecyclerViewAdapter<GroupModel, OnRecyclerItemClickListener,
            DialogGroupsAdapter.BenefitsViewHolder>(context, listener) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_group_dialog, parent), listener)
    }


    inner class BenefitsViewHolder(
        itemView: View,
        private val listener: OnRecyclerItemClickListener
    ) :
        BaseViewHolder<GroupModel, OnRecyclerItemClickListener>(itemView, listener),
        View.OnClickListener {

        init {
            itemView.cb_group.setOnClickListener(this)

        }

        override fun onBind(item: GroupModel) {

            itemView.cb_group.text = item.name
            itemView.cb_group.isChecked = item.select

        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}