package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetCommandRequest(
        @SerializedName("sensorid")
        @Expose var sensorid: String,
        @SerializedName("segid")
        @Expose var segid: String,
        @SerializedName("Userid")
        @Expose var Userid: String,
        @SerializedName("Token")
        @Expose var Token: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)
