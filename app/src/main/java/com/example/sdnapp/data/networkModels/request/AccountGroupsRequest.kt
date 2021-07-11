package com.example.sdnapp.data.networkModels.request

import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.google.gson.annotations.SerializedName

data class AccountGroupsRequest(
        @SerializedName("userid")
        var userid: String = "-200",
        @SerializedName("token")
        var token: String = "5580fb9579dce588b1378939515d9b81",
        @SerializedName("app_version")
        var app_version: Int = 49,
        @SerializedName("_userid")
        var _userid: String = "98af3d52110566829f75bc928aa0ee7b"
)