package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddVehicleRequest(@SerializedName("vehicle_name")
                             @Expose var vehicle_name: String,
                             @SerializedName("plate_no")
                             @Expose var plate_no: String,
                             @SerializedName("license_start")
                             @Expose var license_start: String,
                             @SerializedName("license_end")
                             @Expose var license_end: String,
                             @SerializedName("userid")
                             @Expose var userid: String,
                             @SerializedName("token")
                             @Expose var token: String,
                             @SerializedName("app_version")
                             @Expose var app_version: Int,
                             @SerializedName("_userid")
                             @Expose var _userid: String,

)
