package com.example.sdnapp.ui.dashboard.driver

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.ui.base.BaseFragment
import com.example.sdnapp.ui.dashboard.driver.adapter.DriverAdapter
import com.example.sdnapp.util.Status
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener
import kotlinx.android.synthetic.main.fragment_driver.*
import org.koin.android.ext.android.inject

class DriverFragment : BaseFragment() {
    private val viewModel by inject<DriverViewModel>()
    lateinit var driverAdapter: DriverAdapter
    var driverList = mutableListOf<GetDriverListResponse.Driver>()

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
        getDriverFromWebservices()
        search()
    }

    private fun search() {
        et_driverFragment_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!driverList.isNullOrEmpty() && s != null) {
                    var searchList = driverList.filter {
                        it.driver_name.contains(s)
                    }
                    if (!searchList.isNullOrEmpty()) {
                        setAdapter(searchList)
                    }
                } else if (s == null || s.isEmpty()) {
                    setAdapter(driverList)
                }
            }
        })
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

    private fun setAdapter(data: List<GetDriverListResponse.Driver>) {
        rv_driverFragment_drivers.apply {
            layoutManager = LinearLayoutManager(context)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.VERTICAL
            rv_driverFragment_drivers.layoutManager = layoutManager
            adapter = driverAdapter
        }
        driverAdapter.items = data


    }

    private fun getDriverFromWebservices() {
        viewModel.getDriverListFromWebServices()

    }

    private fun initViewModel() {
        viewModel.getDriverList().observe(requireActivity(), Observer {
            it?.let { resource ->

                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (it.data!!.drivers != null) {
                            setAdapter(it.data.drivers)
                            driverList =
                                it.data.drivers as MutableList<GetDriverListResponse.Driver>
                        }
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