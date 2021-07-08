package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.SerializedName

data class AddVehicleRequest(@SerializedName("vehicle_name") val vehicle_name: String,
                             @SerializedName("plate_no") val plate_no: String,
                             @SerializedName("license_start") val license_start: String,
                             @SerializedName("license_end") val license_end: String,
                             @SerializedName("current_mileage") val current_mileage: String,
                             @SerializedName("gps_unitid") val gps_unitid: String,
                             @SerializedName("groupList") val groupList: List<String>,
                             @SerializedName("max_speed") val max_speed: String,
                             @SerializedName("sim_number") val sim_number: String,
                             @SerializedName("userid") val userid: String = "-200",
                             @SerializedName("token") val token: String = loggedInUser.token,
                             @SerializedName("app_version") val app_version: Int = 49,
                             @SerializedName("_userid") val _userid: String = loggedInUser.userid

)
