package com.example.sdnapp.ui.dashboard.groups

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_add_group.*
import org.koin.android.ext.android.inject

class AddGroupActivity : BaseActivity() {
    private val viewModel by inject<GroupsViewModel>()
    private lateinit var group: AccountGroupsResponse.Group

    private var operationType = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_group)
        if (intent.getStringExtra("type").equals("edit")) {
            operationType = "edit"
            group = intent.getSerializableExtra("group") as AccountGroupsResponse.Group
        } else {
            operationType = "add"
        }
        initViewModel()
        addGroup()
        if (operationType == "edit" && group != null) {
            updateUi()
        }
    }

    private fun updateUi() {
        et_addGroupActivity_groupName.setText(group.group_name)
        btn_addGroupActivity_save.text = getString(R.string.update)
    }

    private fun addGroup() {
        btn_addGroupActivity_save.setOnClickListener(View.OnClickListener {
            if (operationType == "edit" && group != null) {
                editGroupGroupToWebservices()
            } else
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
                        if (it.data!!.type == "ok") {
                            finish()
                        } else {
                            it.message?.let { it1 -> showToast(this, it1) }
                        }
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
        //----------updateAccountGroupName
        viewModel.updateAccountGroupName().observe(this, Observer {
            it?.let { resource ->
                dismissLoading()
                when (resource.status) {
                    Status.SUCCESS -> {
                        showLoading()
                        if (it.data!!.type == "ok") {
                            finish()
                        } else {
                            it.message?.let { it1 -> showToast(this, it1) }
                        }
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
        if (!et_addGroupActivity_groupName.text.isNullOrEmpty())
            viewModel.addAccountGroupsFromWebServices(et_addGroupActivity_groupName.text.toString())
    }

    private fun editGroupGroupToWebservices() {
        if (!et_addGroupActivity_groupName.text.isNullOrEmpty())
            viewModel.updateAccountGroupNameToWebServices(et_addGroupActivity_groupName.text.toString(),
                    group.groupid)
    }
}