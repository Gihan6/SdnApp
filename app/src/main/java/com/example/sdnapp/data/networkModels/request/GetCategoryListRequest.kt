package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetCategoryListRequest(
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("app_version")
        @Expose var app_version: String,
        @SerializedName("_userid")
        @Expose var _userid: String
)
