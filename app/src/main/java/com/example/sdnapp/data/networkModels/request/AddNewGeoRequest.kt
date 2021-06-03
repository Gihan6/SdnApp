package com.example.sdnapp.data.networkModels.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddNewGeoRequest(
        @SerializedName("token")
        @Expose var token: String,
        @SerializedName("userid")
        @Expose var userid: String,
        @SerializedName("color")
        @Expose var color: String,
        @SerializedName("app_version")
        @Expose var app_version: Int,
        @SerializedName("_userid")
        @Expose var _userid: String,
        @SerializedName("description")
        @Expose var description: String,
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("locationData")
        @Expose var locationData: ArrayList<LocationData>
){
    data class LocationData(var lan:Double,var lat:Double)
}

