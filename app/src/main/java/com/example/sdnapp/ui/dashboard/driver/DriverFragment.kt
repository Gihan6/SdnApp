package com.example.sdnapp.ui.dashboard.driver

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.GetDriverListRequest
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.driver.adapter.DriverAdapter
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_driver.*
import org.koin.android.ext.android.inject

class DriverFragment : BaseFragment() {
    private val viewModel by inject<DriverViewModel>()
    lateinit var driverAdapter: DriverAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAdapter()
        addDriver()
        getDataFromWebservices()
    }

    private fun addDriver() {
        btn_driverFragment_addDrive.setOnClickListener(View.OnClickListener {
            goToAddDriver()
        })
    }

    private fun goToAddDriver() {
        val intent = Intent(requireContext(), AddDriverActivity::class.java)
        startActivity(intent)
    }

    private fun initAdapter() {

        driverAdapter = DriverAdapter(
                requireContext(),
                OnRecyclerItemClickListener {

                })

    }

    private fun setAdapter(data: List<String>) {
        rv_driverFragment_drivers.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_driverFragment_drivers.layoutManager = layoutManager
            adapter = driverAdapter
        }
        driverAdapter.items = data


    }

    private fun getDataFromWebservices() {
        viewModel.getDriverListFromWebServices(
                GetDriverListRequest("", "", 1, ""))

    }

    private fun initViewModel() {
        viewModel.getDriverList().observe(requireActivity(), Observer {
            it?.let { resource ->

                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        var data = mutableListOf<String>()
                        data.add("")
                        data.add("")
                        data.add("")
                        data.add("")
                        setAdapter(data)
//                        Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
                    }

                    Status.LOADING -> {
                        dismissLoading()

                    }
                }
            }
        })
    }
}