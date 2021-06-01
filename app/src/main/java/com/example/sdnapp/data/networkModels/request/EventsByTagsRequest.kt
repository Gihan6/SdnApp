package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventsByTagsRequest(
    @SerializedName("start_time")
    @Expose var start_time: String,
    @SerializedName("end_time")
    @Expose var end_time: String,
    @SerializedName("Userid")
    @Expose var Userid: String,
    @SerializedName("Token")
    @Expose var Token: String,
    @SerializedName("app_version")
    @Expose var app_version: Int,
    @SerializedName("_userid")
    @Expose var _userid: String

)
