package com.example.sdnapp.ui.dashboard.vechicle.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.ui.dashboard.vechicle.adapter.DialogGroupsAdapter
import com.example.sdnapp.ui.dashboard.vechicle.adapter.GroupModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.dialog_for_group_layout.*

class DialogForGroups : BottomSheetDialogFragment() {
    private var fragmentView: View? = null
    private var data: ArrayList<AccountGroupsResponse.Data>? = null
    private var position: Int? = null
    private lateinit var migrateCallback: MigrateCallback
    private lateinit var dialogGroupsAdapter: DialogGroupsAdapter
    var selectList = mutableListOf<GroupModel>()

    companion object {
        fun newInstance(data: ArrayList<AccountGroupsResponse.Data>): DialogForGroups? {
            val args = Bundle()
            args.putSerializable("data", data)
            val fragment = DialogForGroups()
            fragment.arguments = args
            return fragment
        }


    }

    fun setMigrateCallback(migrateCallback: MigrateCallback) {
        this@DialogForGroups.migrateCallback = migrateCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = requireArguments().getSerializable("data") as ArrayList<AccountGroupsResponse.Data>?
        initAdapter()
    }

    private fun initAdapter() {
        dialogGroupsAdapter = DialogGroupsAdapter(
            requireContext(),
            OnRecyclerItemClickListener {
                selectList[it].select = !selectList[it].select
                dialogGroupsAdapter.notifyDataSetChanged()

            }
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.dialog_for_group_layout, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

        btnDone.setOnClickListener {
            var selectedGroup = mutableListOf<AccountGroupsResponse.Data>()
            for (i in selectList) {
                if (i.select)
                    selectedGroup.add(i.data)
            }
            migrateCallback.onConfirmClick(selectedGroup)

        }

    }

    private fun setAdapter() {
        selectList = mutableListOf()
        if (data != null) {
            for (i in data!!) {
                selectList.add(GroupModel(i, false))
            }
            rv_groups.apply {
                layoutManager = LinearLayoutManager(activity)
                (layoutManager as LinearLayoutManager).orientation =
                    LinearLayoutManager.VERTICAL
                rv_groups.layoutManager = layoutManager
                adapter = dialogGroupsAdapter
            }
            dialogGroupsAdapter.items = selectList
        }
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialog
    }

    interface MigrateCallback {
        fun onConfirmClick(selectGroups: List<AccountGroupsResponse.Data>)
    }


}