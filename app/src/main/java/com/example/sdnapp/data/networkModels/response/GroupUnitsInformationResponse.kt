package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupUnitsInformationResponse(

        @SerializedName("id")
        @Expose var id: String,
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("name")
        @Expose var name: String
)

