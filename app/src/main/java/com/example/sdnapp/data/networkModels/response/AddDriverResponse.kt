package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.SerializedName

data class AddDriverResponse(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val value: String,
        @SerializedName("text")
        val text: String
)
