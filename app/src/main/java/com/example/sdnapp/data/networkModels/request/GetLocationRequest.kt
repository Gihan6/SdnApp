package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetLocationRequest(
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("min_speed")
        @Expose var min_speed: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String,
        @SerializedName("start_time")
        @Expose var start_time: String,
        @SerializedName("end_time")
        @Expose var end_time: String,
        @SerializedName("end_time")
        @Expose var end_tim25e: ArrayList<String>
)
