package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StartTripResponse(
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("value")
        @Expose var value: ArrayList<String>,
        @SerializedName("text")
        @Expose var text: String
)
