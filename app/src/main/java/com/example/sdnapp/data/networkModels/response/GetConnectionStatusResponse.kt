package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.SerializedName

data class GetConnectionStatusResponse(

    @SerializedName("type") val type: String,
    @SerializedName("data") val connectionStatus: List<Status>
) {
    data class Status(

        @SerializedName("online") val online: Int,
        @SerializedName("offline") val offline: Int
    )
}
