package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetVehicleListResponse(
        @SerializedName("userCategory")
        @Expose var userCategory: String
)
