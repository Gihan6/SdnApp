package com.example.sdnapp.ui.dashboard.groups

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AddAccountGroupsRequest
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_add_group.*
import org.koin.android.ext.android.inject

class AddGroupActivity : BaseActivity() {
    private val viewModel by inject<GroupsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_group)

        initViewModel()
        addGroup()
    }

    private fun addGroup() {
        btn_fragmentGroup_save.setOnClickListener(View.OnClickListener {
            addGroupToWebservices()
        })
    }

    private fun initViewModel() {
        //----------addAccountGroup
        viewModel.addAccountGroups().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it?.message?.let { it1 -> showToast(this, it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }
        })
    }

    private fun addGroupToWebservices() {
        if (!et_fragmentGroup_groupName.text.isNullOrEmpty())
            viewModel.addAccountGroupsFromWebServices(
                    AddAccountGroupsRequest(""))
    }
}