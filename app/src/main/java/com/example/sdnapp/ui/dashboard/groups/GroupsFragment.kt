package com.example.sdnapp.ui.dashboard.groups

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AccountGroupsRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.groups.adapter.MainGroupsAdapter
import com.example.sdnapp.ui.dashboard.vechicle.ui.AddVehiclesActivity
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_groups.*
import kotlinx.android.synthetic.main.fragment_vehicle.*
import org.koin.android.ext.android.inject

class GroupsFragment : BaseFragment() {
    private val viewModel by inject<GroupsViewModel>()
    lateinit var mainGroupsAdapter: MainGroupsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        getGroups()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initAdapter()
        initViewModel()
        addGroup()


    }

    private fun addGroup() {
        btn_fragmentGroup_addGroup.setOnClickListener(View.OnClickListener {
            var intent = Intent(requireContext(), AddGroupActivity::class.java)
            startActivity(intent)

        })
    }

    private fun initAdapter() {

        mainGroupsAdapter = MainGroupsAdapter(
            requireContext(),
            OnRecyclerItemClickListener {

            })

    }

    private fun setAdapter(data: List< AccountGroupsResponse.Group>) {
        rv_fragmentGroup_Group.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_fragmentGroup_Group.layoutManager = layoutManager
            adapter = mainGroupsAdapter
        }
        mainGroupsAdapter.items = data


    }
    private fun getGroups() {
        viewModel.accountGroupsFromWebServices()

    }

    private fun initViewModel() {
        viewModel.accountGroups().observe(requireActivity(), androidx.lifecycle.Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (!it.data!!.groups.isNullOrEmpty())
                           setAdapter(it.data!!.groups)
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(requireContext(), it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }

            }
        })
    }
}