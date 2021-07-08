package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.SerializedName

data class GetVehicleListRequest(
    @SerializedName("userid") val userid: String="-200",
    @SerializedName("token") val token: String=loggedInUser.token,
    @SerializedName("app_version") val app_version: Int=49,
    @SerializedName("_userid") val _userid: String=loggedInUser.userid
)
