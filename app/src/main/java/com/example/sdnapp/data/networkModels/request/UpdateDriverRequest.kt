package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateDriverRequest(
        @SerializedName("driver_name")
        @Expose var driver_name: String,
        @SerializedName("license_number")
        @Expose var license_number: String,
        @SerializedName("license_start")
        @Expose var license_start: String,
        @SerializedName("license_end")
        @Expose var license_end: String,
        @SerializedName("current_mileage")
        @Expose var current_mileage: String,
        @SerializedName("driverid")
        @Expose var driverid: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)


