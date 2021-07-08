package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.SerializedName

data class GetConnectionStatusRequest(
    @SerializedName("type") var type: String = "vehicle",
    @SerializedName("Userid") var Userid: String = "-200",
    @SerializedName("Token") var Token: String = "Bearer  "+loggedInUser.token,
    @SerializedName("app_version") var app_version: Int = 49,
    @SerializedName("_userid") var _userid: String = loggedInUser.userid,
)