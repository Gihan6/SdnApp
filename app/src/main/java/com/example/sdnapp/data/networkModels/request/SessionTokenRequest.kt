package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SessionTokenRequest(
    @SerializedName("email")
    @Expose var email: String,
    @SerializedName("password")
    @Expose var password: String,
    @SerializedName("raw")
    @Expose var raw: Boolean
)