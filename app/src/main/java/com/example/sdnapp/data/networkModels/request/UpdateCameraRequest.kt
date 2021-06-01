package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateCameraRequest(
        @SerializedName("registerid")
        @Expose var registerid: String,
        @SerializedName("end_time")
        @Expose var end_time: String,
        @SerializedName("sensor_name")
        @Expose var sensor_name: String,
        @SerializedName("ai_type")
        @Expose var ai_type: String,
        @SerializedName("sensorid")
        @Expose var sensorid: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("Token")
        @Expose var Token: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)

