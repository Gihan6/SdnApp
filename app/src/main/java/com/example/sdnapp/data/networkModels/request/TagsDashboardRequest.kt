package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TagsDashboardRequest(
    @SerializedName("filter_period")
    @Expose var filter_period: String,
    @SerializedName("userid")
    @Expose var userid: String,
    @SerializedName("app_version")
    @Expose var app_version: Int,
    @SerializedName("_userid")
    @Expose var _userid: String
    )