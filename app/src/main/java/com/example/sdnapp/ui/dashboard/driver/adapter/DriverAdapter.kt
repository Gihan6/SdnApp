package com.example.sdnapp.ui.dashboard.driver.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.leodroidcoder.genericadapter.BaseRecyclerListener
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_driver.view.*

class DriverAdapter(context: Context, listener: OnRecyclerItemClickListenerForDriver) :
        GenericRecyclerViewAdapter<GetDriverListResponse.Driver, DriverAdapter.OnRecyclerItemClickListenerForDriver,
                DriverAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_driver, parent), listener)
    }


    inner class BenefitsViewHolder(itemView: View, private val listener: OnRecyclerItemClickListenerForDriver) :
            BaseViewHolder<GetDriverListResponse.Driver, OnRecyclerItemClickListenerForDriver>(itemView, listener), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
            itemView.iv_singleLayoutDriver_edit.setOnClickListener(View.OnClickListener {
                listener.onItemClick(adapterPosition, edit = true, delete = false)

            })
            itemView.iv_singleLayoutDriver_delete.setOnClickListener(View.OnClickListener {

                listener.onItemClick(adapterPosition, edit = false, delete = true)
            })
        }

        override fun onBind(item: GetDriverListResponse.Driver) {

            itemView.tv_singleLayoutDriver_driverName.setText(item.driver_name)
            itemView.tv_singleLayoutDriver_licenseNumber.setText(item.license_number)
            itemView.tv_singleLayoutDriver_score.setText(item.driving_score)
            itemView.tv_singleLayoutDriver_localScore.setText(item.local_perc_score)
            itemView.tv_singleLayoutDriver_sdnScore.setText(item.sdn_perc_score)
            itemView.tv_singleLayoutDriver_startDate.setText(itemView.context.getString(R.string.license_start) + " : " + item.license_start)
            itemView.tv_singleLayoutDriver_endDate.setText(itemView.context.getString(R.string.license_start) + " : " + item.license_end)
            itemView.tv_singleLayoutDriver_mileAge.setText(item.current_mileage)



        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition, edit = false, delete = false)
        }
    }

    interface OnRecyclerItemClickListenerForDriver : BaseRecyclerListener {

        fun onItemClick(position: Int,edit:Boolean,delete:Boolean)
    }

}
