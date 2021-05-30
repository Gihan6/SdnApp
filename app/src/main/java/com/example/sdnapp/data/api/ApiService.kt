package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.data.networkModels.response.*
import retrofit2.http.POST



interface ApiService {

    @POST("user.getsessiontoken")
    suspend fun getSessionToken(request: SessionTokenRequest): SessionTokenResponse

    @POST("event.getaccountevents")
    suspend fun getAccountEvents(request: AccountEventRequest): AccountEventResponse

    @POST("event.geteventsbytags")
    suspend fun getEventsByTags(request: EventsByTagsRequest): EventsByTagsResponse

    @POST("event.geteventsbytags")
    suspend fun getTagsDashboard(request: TagsDashboardRequest): TagsDashboardResponse

    @POST("cam.addcam")
    suspend fun addCamera(request: AddCameraRequest): AddCameraResponse

    @POST("cam.getcamlist")
    suspend fun getCameraList(request: CameraListRequest): CameraListResponse

    @POST("cam.updatecam")
    suspend fun updateCamera(request: UpdateCameraRequest): UpdateCameraResponse

    @POST("cam.deletecam")
    suspend fun deleteCamera(request: DeleteCameraRequest): DeleteCameraResponse

    @POST("cam.getcambyid")
    suspend fun getCameraById(request: CameraByIdRequest): CameraByIdResponse

    @POST("cam.updatesilentmode")
    suspend fun updateSilentMode(request: UpdateSilentModeRequest): UpdateSilentModeResponse

    @POST("cam.sendcommand")
    suspend fun sendCommand(request: SendCommandRequest): SendCommandResponse

    @POST("cam.getcommand")
    suspend fun getCommand(request: GetCommandRequest): GetCommandResponse

    @POST("cam.updatecommand")
    suspend fun updateCommand(request: UpdateCommandRequest): UpdateCommandResponse





}