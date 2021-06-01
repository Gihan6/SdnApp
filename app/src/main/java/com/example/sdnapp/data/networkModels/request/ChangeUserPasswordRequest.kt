package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChangeUserPasswordRequest(
        @SerializedName("email")
        @Expose var email: String,
        @SerializedName("old_password")
        @Expose var old_password: String,
        @SerializedName("new_password")
        @Expose var new_password: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String
)
