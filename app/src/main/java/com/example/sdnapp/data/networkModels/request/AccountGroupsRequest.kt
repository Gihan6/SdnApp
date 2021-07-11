package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.SerializedName

data class AccountGroupsRequest(
        @SerializedName("userid")
        var userid: String = "-200",
        @SerializedName("token")
        var token: String = loggedInUser.token,
        @SerializedName("app_version")
        var app_version: Int = 49,
        @SerializedName("_userid")
        var _userid: String = loggedInUser.userid

)