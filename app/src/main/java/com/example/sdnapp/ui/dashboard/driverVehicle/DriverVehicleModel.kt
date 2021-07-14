package com.example.sdnapp.ui.dashboard.driverVehicle

import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse

data class DriverVehicleModel(
    val driver: GetDriverListResponse.Driver,
    val vehicle: GetVehicleListResponse.Vehicle
)
