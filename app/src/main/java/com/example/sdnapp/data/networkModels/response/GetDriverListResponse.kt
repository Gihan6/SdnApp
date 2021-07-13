package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.SerializedName

data class GetDriverListResponse(
        @SerializedName("type") val type: String,
        @SerializedName("data") val drivers: List<Driver>
) {

        data class Driver(

                @SerializedName("driverid") val driverid: String,
                @SerializedName("driver_name") val driver_name: String,
                @SerializedName("license_start") val license_start: String,
                @SerializedName("license_end") val license_end: String,
                @SerializedName("license_number") val license_number: String,
                @SerializedName("license_info") val license_info: String,
                @SerializedName("id_info") val id_info: String,
                @SerializedName("accountid") val accountid: String,
                @SerializedName("last_update") val last_update: String,
                @SerializedName("last_location") val last_location: String,
                @SerializedName("last_loc_update") val last_loc_update: String,
                @SerializedName("current_mileage") val current_mileage: String,
                @SerializedName("driving_score") val driving_score: String,
                @SerializedName("vehicleid") val vehicleid: String,
                @SerializedName("vehicle_name") val vehicle_name: String,
                @SerializedName("plate_no") val plate_no: String,
                @SerializedName("local_perc_score") val local_perc_score: String,
                @SerializedName("global_perc_score") val global_perc_score: String,
                @SerializedName("sdn_perc_score") val sdn_perc_score: String
        )
}
