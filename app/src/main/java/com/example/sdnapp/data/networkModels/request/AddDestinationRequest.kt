package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddDestinationRequest(
        @SerializedName("zones")
        @Expose var zones: ArrayList<Zone>,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("token")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String,
)

data class Zone(
        @SerializedName("id")
        @Expose var id: String,
        @SerializedName("isCloser")
        @Expose var isCloser: Boolean,
        @SerializedName("splitDistance")
        @Expose var splitDistance: Boolean
)
