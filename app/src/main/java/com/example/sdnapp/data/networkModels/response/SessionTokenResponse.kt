package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SessionTokenResponse(
    @SerializedName("type")
    @Expose
    var type: String,
    @SerializedName("data")
    @Expose
    var data: Data
) {
    data class Data(
            @SerializedName("userid")
            @Expose
            var userid: String,
            @SerializedName("token")
            @Expose
            var token: String)


}

