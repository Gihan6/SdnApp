package com.example.sdnapp.ui.dashboard.vechicle.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AddVehicleRequest
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_vechicles.*
import org.koin.android.ext.android.inject
import java.util.*


class AddVehiclesActivity : BaseActivity(), DatePickerDialog.OnDateSetListener {
    private val viewModel by inject<VehicleViewModel>()

    private var groups = mutableListOf<String>()
    private lateinit var dateBaker: DatePickerDialog
    private lateinit var dialogForGroups: DialogForGroups
    private var startOrEnd = 0
    private var isGroupDialog = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vechicles)

        initGroupDialog()
        initDateBaker()
        initOnClick()
        initViewModel()

    }

    private fun addGroupToWebServices(){

        viewModel.addVehicleToWebServices(
            AddVehicleRequest("", "", "", "",
                "", "", 1, ""))


        viewModel.addVehicleToWebServices(
            AddVehicleRequest("", "", "", "",
                "", "", 1, "")
        )

    }
    private fun initViewModel() {

        viewModel.addVehicle().observe(this, androidx.lifecycle.Observer {

            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                    }
                    Status.ERROR -> {
                        dialogForGroups
                    }
                    Status.LOADING -> {
                        showLoading()
                        Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun initGroupDialog() {
        dialogForGroups = DialogForGroups.newInstance(groups as ArrayList<String>)!!

    }

    private fun initOnClick() {

        et_licenseStart.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 1
            v?.onTouchEvent(event) ?: true
        }
        et_licenseEnd.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 2
            v?.onTouchEvent(event) ?: true
        }
        et_group.setOnTouchListener { v, event ->
            if (!isGroupDialog)
                openGroupDialog()

            v?.onTouchEvent(event) ?: true
        }

        btn_save.setOnClickListener(
            View.OnClickListener
            {

                finish()
            })
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

    private fun showDateBacker() {

        if (!dateBaker.isShowing)
            dateBaker.show()
    }

    private fun openGroupDialog() {
        groups = mutableListOf()
        groups.add("Group 1")
        groups.add("Group 2")
        groups.add("Group 3")
        groups.add("Group 4")
        groups.add("Group 5")
        groups.add("Group 6")

        dialogForGroups = DialogForGroups.newInstance(groups as ArrayList<String>)!!
        dialogForGroups.setMigrateCallback(object : DialogForGroups.MigrateCallback {
            override fun onConfirmClick(selectGroups: List<String>) {
                var selectData = ""
                for (i in selectGroups) {
                    selectData += "$i  "
                }
                et_group.setText(selectData)
                dialogForGroups.dismiss()
                isGroupDialog = false

            }
        })

        isGroupDialog = true
        dialogForGroups?.show(supportFragmentManager, dialogForGroups.tag)

    }

    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

        val date = dayOfMonth.toString() + "/" + (monthOfYear + 1).toString() + "/" + year
        if (startOrEnd == 1) {
            et_licenseStart.setText(date)
        } else if (startOrEnd == 2) {
            et_licenseEnd.setText(date)
        }
    }


}