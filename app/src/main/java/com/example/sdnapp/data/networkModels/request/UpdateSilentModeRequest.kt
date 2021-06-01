package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateSilentModeRequest(
        @SerializedName("sensorid")
        @Expose var sensorid: String,
        @SerializedName("silent_mode")
        @Expose var silent_mode: Boolean,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)
