package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetLocationResponse(
        @SerializedName("type") val type : String,
        @SerializedName("data") val locations : List<Location>
) {
        data class Location (

                @SerializedName("objectid") val objectid : Int,
                @SerializedName("loc_day") val loc_day : String,
                @SerializedName("loc_time") val loc_time : String,
                @SerializedName("accuracy") val accuracy : Int,
                @SerializedName("dev_mileage") val dev_mileage : Int,
                @SerializedName("extrajson") val extrajson : String,
                @SerializedName("fuel") val fuel : Int,
                @SerializedName("heading") val heading : Int,
                @SerializedName("lat") val lat : Double,
                @SerializedName("lng") val lng : Double,
                @SerializedName("sdn_mileage") val sdn_mileage : Double,
                @SerializedName("speed") val speed : Int,
                @SerializedName("idle_time") val idle_time : Int
        )
}

