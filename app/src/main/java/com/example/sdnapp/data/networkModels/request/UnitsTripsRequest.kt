package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UnitsTripsRequest(
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String,
        @SerializedName("unitsids")
        @Expose var unitsids: ArrayList<String>
)
