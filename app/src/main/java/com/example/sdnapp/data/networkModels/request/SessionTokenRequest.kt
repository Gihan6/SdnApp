package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SessionTokenRequest(
    @SerializedName("email")
    @Expose var email: String,
    @SerializedName("password")
    @Expose var password: String,
    @SerializedName("raw")
    @Expose var raw: Boolean,
    @SerializedName("userid")
    @Expose var userid: String="-200",
    @SerializedName("token")
    @Expose var token: String="",
    @SerializedName("app_version")
    @Expose var app_version: Int=49,
    @SerializedName("_userid")
    @Expose var _userid: String="na"
)
