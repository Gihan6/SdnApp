package com.example.sdnapp.ui.dashboard.groups

import android.os.Bundle
import android.view.View
import com.example.sdnapp.R
import com.example.sdnapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_group.*
import org.koin.android.ext.android.inject

class AddGroupActivity : BaseActivity() {
    private val viewModel by inject<GroupsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_group)

        addGroup()
    }

    private fun addGroup() {
        btn_fragmentGroup_save.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    private fun initViewModel() {

    }

    private fun addGroupToWebservices() {

    }
}