package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.SerializedName

data class AddDriverRequest(
    @SerializedName("driver_name") val driver_name: String,
    @SerializedName("license_number") val license_number: String,
    @SerializedName("license_start") val license_start: String,
    @SerializedName("license_end") val license_end: String,
    @SerializedName("current_mileage") var current_mileage: String,
    @SerializedName("userid") val userid: String,
    @SerializedName("token") val token: String,
    @SerializedName("app_version") val app_version: Int,
    @SerializedName("_userid") val _userid: String
)


