package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetDriverListRequest(
        @SerializedName("userid")
        @Expose var userid: String="-200",
        @SerializedName("token")
        @Expose var token: String=loggedInUser.token,
        @SerializedName("app_version")
        @Expose var app_version: Int=49,
        @SerializedName("_userid")
        @Expose var _userid: String=loggedInUser.userid
)
