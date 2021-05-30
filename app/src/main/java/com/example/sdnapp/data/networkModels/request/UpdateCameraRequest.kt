package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateCameraRequest(
        @SerializedName("registerid")
        @Expose var registerid: String,
        @SerializedName("end_time")
        @Expose var sensor_name: String,
        @SerializedName("sensor_name")
        @Expose var Userid: String,
        @SerializedName("Token")
        @Expose var Token: String,
        @SerializedName("app_version")
        @Expose var app_version: String,
)

