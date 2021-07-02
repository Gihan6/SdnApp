package com.example.sdnapp.ui.dashboard.driver

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AddDriverRequest
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_add_driver_a_ctivity.*
import org.koin.android.ext.android.inject
import java.util.*

class AddDriverActivity : BaseActivity(), DatePickerDialog.OnDateSetListener {
    private val viewModel by inject<DriverViewModel>()
    private lateinit var dateBaker: DatePickerDialog
    private var startOrEnd = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_driver_a_ctivity)
        initDateBaker()
        initOnClick()
        initViewModel()

    }

    private fun initViewModel() {

        //----------addDriver
        viewModel.addDriver().observe(this, androidx.lifecycle.Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                    }
                    Status.ERROR -> {
                        dismissLoading()
                    }
                    Status.LOADING -> {
                        showLoading()
                        Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
                    }
                }
            }

        })
    }

    private fun addDriverToWebServices() {
        viewModel.addDriverToWebServices(
            AddDriverRequest(
                "", "", "", "",
                "", "", "", 1, ""
            )
        )
    }

    private fun initDateBaker() {
        val cal: Calendar = Calendar.getInstance()
        dateBaker = DatePickerDialog(
            this, this,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )
    }

    private fun initOnClick() {

        et_addDriverActivity_licenseStart.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 1
            v?.onTouchEvent(event) ?: true
        }
        et_addDriverActivity_licenseEnd.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 2
            v?.onTouchEvent(event) ?: true
        }

        btn_addDriverActivity_save.setOnClickListener(
            View.OnClickListener
            {

                finish()
            })
    }

    private fun showDateBacker() {

        if (!dateBaker.isShowing)
            dateBaker.show()

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val date = dayOfMonth.toString() + "/" + (month + 1).toString() + "/" + year


        if (startOrEnd == 1) {
            et_addDriverActivity_licenseStart.setText(date)
        } else if (startOrEnd == 2) {
            et_addDriverActivity_licenseEnd.setText(date)
        }
    }
}