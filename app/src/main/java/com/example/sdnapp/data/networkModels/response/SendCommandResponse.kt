package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SendCommandResponse(
        @SerializedName("result")
        @Expose
        var result: String,
)
