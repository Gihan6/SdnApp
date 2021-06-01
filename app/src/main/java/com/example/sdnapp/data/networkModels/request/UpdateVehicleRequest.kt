package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateVehicleRequest(
        @SerializedName("response")
        @Expose var response: String
)
