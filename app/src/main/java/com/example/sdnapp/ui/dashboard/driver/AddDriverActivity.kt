package com.example.sdnapp.ui.dashboard.driver

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AddDriverRequest
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
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
                        showToast(this,it.data!!.text)
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(this,it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }

        })
    }

    private fun addDriverToWebServices() {
        viewModel.addDriverToWebServices(
            AddDriverRequest(
                et_addDriverActivity_driverName.text.toString(),
                et_addDriverActivity_plate.text.toString(),
                et_addDriverActivity_licenseStart.text.toString(),
                et_addDriverActivity_licenseEnd.text.toString(),
                et_addDriverActivity_currentMiles.text.toString(),
                "-200", loggedInUser.token, 49, loggedInUser.userid
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

                if(validate()){
                    addDriverToWebServices()
                }

            })
    }

    private fun showDateBacker() {

        if (!dateBaker.isShowing)
            dateBaker.show()

    }
    private fun validate():Boolean{
        var valid=true
        when {
            et_addDriverActivity_plate.text.isNullOrEmpty() -> {
                valid=false
                return valid
            }
            et_addDriverActivity_driverName.text.isNullOrEmpty() -> {
                valid=false
                return valid
            }
            et_addDriverActivity_licenseStart.text.isNullOrEmpty() -> {
                valid=false
                return valid
            }
            et_addDriverActivity_licenseEnd.text.isNullOrEmpty() -> {
                valid=false
                return valid
            }
            et_addDriverActivity_currentMiles.text.isNullOrEmpty() -> {
                valid=false
                return valid
            }
            else -> return valid
        }
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