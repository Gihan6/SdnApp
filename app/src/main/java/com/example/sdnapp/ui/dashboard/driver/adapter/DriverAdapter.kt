package com.example.sdnapp.ui.dashboard.driver.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.ui.dashboard.vechicle.adapter.GroupsAdapter
import com.leodroidcoder.genericadapter.BaseViewHolder
import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.single_layout_driver.view.*
import kotlinx.android.synthetic.main.single_layout_vehicle.view.*

class DriverAdapter(context: Context, listener: OnRecyclerItemClickListener) :
        GenericRecyclerViewAdapter<GetDriverListResponse.Data, OnRecyclerItemClickListener,
                DriverAdapter.BenefitsViewHolder>(context, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitsViewHolder {
        return BenefitsViewHolder(inflate(R.layout.single_layout_driver, parent), listener)
    }


    inner class BenefitsViewHolder(itemView: View, private val listener: OnRecyclerItemClickListener) :
            BaseViewHolder<GetDriverListResponse.Data, OnRecyclerItemClickListener>(itemView, listener), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onBind(item: GetDriverListResponse.Data) {

            itemView.tv_singleLayoutDriver_driverName.text=item.driver_name
            itemView.tv_singleLayoutDriver_licenseNumber.text=item.license_number.toString()
            itemView.tv_singleLayoutDriver_score.text=item.driving_score.toString()
            itemView.tv_singleLayoutDriver_localScore.text=item.local_perc_score.toString()
            itemView.tv_singleLayoutDriver_sdnScore.text=item.sdn_perc_score.toString()
            itemView.tv_singleLayoutDriver_startDate.text=item.license_start
            itemView.tv_singleLayoutDriver_endDate.text=item.license_end
            itemView.tv_singleLayoutDriver_mileAge.text=item.current_mileage.toString()



        }

        override fun onClick(view: View) {
            listener.onItemClick(adapterPosition)
        }
    }
}
