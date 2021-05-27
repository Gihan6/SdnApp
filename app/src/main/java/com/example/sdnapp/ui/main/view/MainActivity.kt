package com.example.sdnapp.ui.main.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.sdnapp.R
import com.example.sdnapp.model.Repo
import com.example.sdnapp.ui.main.adapter.ListenerAdapter
import com.example.sdnapp.ui.main.adapter.MainAdapter
import com.example.sdnapp.ui.main.viewModel.MainViewModel
import com.example.sdnapp.util.Status
import com.example.sdnapp.ui.base.BaseActivity

import org.koin.android.ext.android.inject


// SwipeRefreshLayout.OnRefreshListener
class MainActivity : BaseActivity(), ListenerAdapter {

    private val viewModel by inject<MainViewModel>()
    private lateinit var adapter: MainAdapter
    var currentPage = 0
    var noData = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListenerForViewModel()
        getDataFromServer(currentPage)
        showLoading()

    }





    private fun initAdapter() {
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter = MainAdapter(arrayListOf(), this)
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter

    }




    private fun getDataFromServer(page: Int) {
//        progressBar.visibility = View.VISIBLE
        viewModel.getReposFromWebServices(page)

    }


    override fun onLongClick(position: Repo) {

    }



    private fun initListenerForViewModel() {
        viewModel.getRepos().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                    }
                    Status.ERROR -> {
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

}
