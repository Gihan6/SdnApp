package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetLatsActivitiesTypesResponse(
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("data")
        @Expose var data: ArrayList<String>
)

