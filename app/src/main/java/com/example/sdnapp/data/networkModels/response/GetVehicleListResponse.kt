package com.example.sdnapp.data.networkModels.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetVehicleListResponse(
        @SerializedName("type") val type : String,
        @SerializedName("data") val Vehicles : List<Vehicle>
) {

        data class Vehicle(
                @SerializedName("vehicleid") val vehicleid: String,
                @SerializedName("plate_no") val plate_no: String,
                @SerializedName("vehicle_name") val vehicle_name: String,
                @SerializedName("license_start") val license_start: String,
                @SerializedName("license_end") val license_end: String,
                @SerializedName("accountid") val accountid: String,
                @SerializedName("current_driverid") val current_driverid: String,
                @SerializedName("last_location") val last_location: String,
                @SerializedName("last_loc_update") val last_loc_update: String,
                @SerializedName("current_mileage") val current_mileage: Int,
                @SerializedName("gps_unitid") val gps_unitid: String,
                @SerializedName("sim_number") val sim_number: String,
                @SerializedName("max_speed") val max_speed: String,
                @SerializedName("last_command") val last_command: String,
                @SerializedName("fuel_fr") val fuel_fr: String,
                @SerializedName("density") val density: String,
                @SerializedName("cc") val cc: String,
                @SerializedName("ve") val ve: String,
                @SerializedName("driverid") val driverid: String,
                @SerializedName("driver_name") val driver_name: String,
                @SerializedName("license_number") val license_number: String,
                @SerializedName("license_info") val license_info: String,
                @SerializedName("id_info") val id_info: String,
                @SerializedName("last_update") val last_update: String,
                @SerializedName("driving_score") val driving_score: Int,
                @SerializedName("location_lng") val location_lng: Double,
                @SerializedName("location_lat") val location_lat: Double,
                @SerializedName("last_update_date") val last_update_date: String,
                @SerializedName("vehicle_license_start") val vehicle_license_start: String,
                @SerializedName("vehicle_license_end") val vehicle_license_end: String,
                @SerializedName("vehicle_current_mileage") val vehicle_current_mileage: Int,
                @SerializedName("vehicleAccOn") val vehicleAccOn: Boolean,
                @SerializedName("groups") val groups: List<Group>,
                var select: Boolean =false
        )
        data class Group (
                @SerializedName("groupid") val groupid : String,
                @SerializedName("group_name") val group_name : String,
                @SerializedName("accountid") val accountid : String,
                @SerializedName("icon_url") val icon_url : String,
                @SerializedName("unitid") val units : String
        )
}
