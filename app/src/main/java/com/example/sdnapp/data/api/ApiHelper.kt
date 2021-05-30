package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.*


class ApiHelper (private val apiService: ApiService) {
    suspend fun getSessionToken(request: SessionTokenRequest) = apiService.getSessionToken(request)

    suspend fun getAccountEvents(request: AccountEventRequest) =
            apiService.getAccountEvents(request)

    suspend fun getEventByTags(request: EventsByTagsRequest) = apiService.getEventsByTags(request)

    suspend fun getTagsDashboard(request: TagsDashboardRequest) = apiService.getTagsDashboard(request)

    suspend fun addCamera(request: AddCameraRequest) = apiService.addCamera(request)

    suspend fun getCameraList(request: CameraListRequest) = apiService.getCameraList(request)

    suspend fun updateCamera(request: UpdateCameraRequest) = apiService.updateCamera(request)

    suspend fun deleteCamera(request: DeleteCameraRequest) = apiService.deleteCamera(request)

    suspend fun getCameraById(request: CameraByIdRequest) = apiService.getCameraById(request)

    suspend fun updateSilentMode(request: UpdateSilentModeRequest) =
            apiService.updateSilentMode(request)

    suspend fun sendCommand(request: SendCommandRequest) =
            apiService.sendCommand(request)

    suspend fun getCommand(request: GetCommandRequest) =
            apiService.getCommand(request)
    suspend fun updateCommand(request: UpdateCommandRequest) =
            apiService.updateCommand(request)

}