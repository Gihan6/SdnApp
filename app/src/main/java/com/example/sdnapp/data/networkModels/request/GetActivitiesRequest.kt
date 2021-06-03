package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetActivitiesRequest(
        @SerializedName("activity_type")
        @Expose var activity_type: String,
        @SerializedName("units")
        @Expose var units: ArrayList<String>,
        @SerializedName("startDate")
        @Expose var startDate: String,
        @SerializedName("endDate")
        @Expose var endDate: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)
