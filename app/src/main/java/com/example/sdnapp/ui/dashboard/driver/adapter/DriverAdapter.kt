package com.example.sdnapp.ui.dashboard.driver.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.ui.dashboard.vechicle.adapter.GroupsAdapter
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_vehicle.view.*

class DriverAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        GenericRecyclerViewAdapter<String, OnRecyclerItemClickListener,
                DriverAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_driver, parent), listener)
    }


    inner class BenefitsViewHolder(itemView: View, private val listener: OnRecyclerItemClickListener) :
            BaseViewHolder<String, OnRecyclerItemClickListener>(itemView, listener), View.OnClickListener {

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
