package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetLocationResponse(
        @SerializedName("type")
        @Expose var type: String,
        @SerializedName("data")
        @Expose var data: ArrayList<Data>
) {
    data class Data(
            @SerializedName("objectid")
            @Expose var objectid: String,
            @SerializedName("loc_day")
            @Expose var loc_day: String,
            @SerializedName("loc_time")
            @Expose var loc_time: String,
            @SerializedName("accuracy")
            @Expose var accuracy: Double,
            @SerializedName("dev_mileage")
            @Expose var dev_mileage: String,
            @SerializedName("extrajson")
            @Expose var extrajson: String,
            @SerializedName("heading")
            @Expose var heading: String,
            @SerializedName("lat")
            @Expose var lat: String,
            @SerializedName("lng")
            @Expose var lng: Double,
            @SerializedName("sdn_mileage")
            @Expose var sdn_mileage: String,
            @SerializedName("speed")
            @Expose var speed: String
    )
}

