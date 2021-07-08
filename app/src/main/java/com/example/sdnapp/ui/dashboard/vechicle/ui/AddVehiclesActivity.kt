package com.example.sdnapp.ui.dashboard.vechicle.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.example.sdnapp.R
import com.example.sdnapp.data.networkModels.request.AccountGroupsRequest
import com.example.sdnapp.data.networkModels.request.AddVehicleRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.ui.base.BaseActivity
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
import com.example.sdnapp.util.Status
import kotlinx.android.synthetic.main.activity_vechicles.*
import org.koin.android.ext.android.inject
import java.util.*


class AddVehiclesActivity : BaseActivity(), DatePickerDialog.OnDateSetListener {
    private val viewModel by inject<VehicleViewModel>()

    private var groups = listOf<AccountGroupsResponse.Data>()
    private lateinit var selectGroupsId: MutableList<String>
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
        getGroups()
    }

    private fun validate(): Boolean {
        var valid = true
        when {
            et_addVehicleActivity_plate.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_vehicleName.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_licenseStart.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_licenseEnd.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_gpsUnit.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_currentMilAge.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
//            et_addVehicleActivity_group.text.isNullOrEmpty() -> {
//                valid = false
//                return valid
//            }
            et_addVehicleActivity_sim.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            et_addVehicleActivity_maxSpeed.text.isNullOrEmpty() -> {
                valid = false
                return valid
            }
            else -> return valid
        }
    }

    private fun addVehicleToWebServices() {
        if (validate()) {
            selectGroupsId = listOf<String>().toMutableList()
            selectGroupsId.add("nm")
            viewModel.addVehicleToWebServices(
                    AddVehicleRequest(
                            et_addVehicleActivity_vehicleName.text.toString(),
                            et_addVehicleActivity_plate.text.toString(),
                            et_addVehicleActivity_licenseStart.text.toString(),
                            et_addVehicleActivity_licenseEnd.text.toString(),
                            et_addVehicleActivity_currentMilAge.text.toString(),
                            et_addVehicleActivity_gpsUnit.text.toString(),
                            selectGroupsId,
                            et_addVehicleActivity_maxSpeed.text.toString(),
                            et_addVehicleActivity_sim.text.toString(),
                    )
            )
        }
    }

    private fun getGroups() {
        viewModel.accountGroupsFromWebServices(
                AccountGroupsRequest()
        )

    }

    private fun initViewModel() {
        //----------accountGroups
        viewModel.accountGroups().observe(this, androidx.lifecycle.Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()
                        if (!it.data!!.data.isNullOrEmpty())
                            groups = it.data!!.data
                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(this, it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }

            }
        })
        viewModel.addVehicle().observe(this, androidx.lifecycle.Observer {

            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        dismissLoading()


                    }
                    Status.ERROR -> {
                        dismissLoading()
                        it.message?.let { it1 -> showToast(this, it1) }
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }
        })
    }

    private fun initGroupDialog() {
        if (groups != null && groups.isNotEmpty())
            dialogForGroups =
                    DialogForGroups.newInstance(groups as ArrayList<AccountGroupsResponse.Data>)!!

    }

    private fun initOnClick() {

        et_addVehicleActivity_licenseStart.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 1
            v?.onTouchEvent(event) ?: true
        }
        et_addVehicleActivity_licenseEnd.setOnTouchListener { v, event ->
            showDateBacker()
            startOrEnd = 2
            v?.onTouchEvent(event) ?: true
        }
        et_addVehicleActivity_group.setOnTouchListener { v, event ->
            if (!isGroupDialog)
                openGroupDialog()

            v?.onTouchEvent(event) ?: true
        }

        btn_addVehicleActivity_save.setOnClickListener(
                View.OnClickListener
                {

                    addVehicleToWebServices()
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

        if (groups != null && groups.isNotEmpty()) {
            selectGroupsId = listOf<String>().toMutableList()

            dialogForGroups =
                    DialogForGroups.newInstance(groups as ArrayList<AccountGroupsResponse.Data>)!!
            dialogForGroups.setMigrateCallback(object : DialogForGroups.MigrateCallback {
                override fun onConfirmClick(selectGroups: List<AccountGroupsResponse.Data>) {
                    var selectData = ""
                    for (i in selectGroups) {
                        selectData += "${i.group_name}  "
                        selectGroupsId.add(i.groupid)
                    }
                    et_addVehicleActivity_group.setText(selectData)
                    dialogForGroups.dismiss()
                    isGroupDialog = false

                }
            })

            isGroupDialog = true
            dialogForGroups?.show(supportFragmentManager, dialogForGroups.tag)
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

        val date = dayOfMonth.toString() + "/" + (monthOfYear + 1).toString() + "/" + year
        if (startOrEnd == 1) {
            et_addVehicleActivity_licenseStart.setText(date)
        } else if (startOrEnd == 2) {
            et_addVehicleActivity_licenseEnd.setText(date)
        }
    }


}