package com.example.sdnapp.ui.dashboard.liveTracking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import kotlinx.android.synthetic.main.single_layout_spinner_group.view.*

class SpinnerGroupAdapter (val context: Context, private var dataSource: List<AccountGroupsResponse.Group>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView
            ?: inflater.inflate(R.layout.single_layout_spinner_group, parent, false)
        view.tv_singleLayoutSpinnerGroup_groupName.text = dataSource[position].group_name


        return view
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}
