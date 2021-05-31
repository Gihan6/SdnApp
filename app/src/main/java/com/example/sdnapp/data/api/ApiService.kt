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

    @POST("account.adduser")
    suspend fun addUser(request: AddUserRequest): AddUserResponse

    @POST("account.edituser")
    suspend fun editUser(request: EditUserRequest): EditUserResponse

    @POST("account.deleteuser")
    suspend fun deleteUser(request: DeleteUserRequest): DeleteUserResponse

    @POST("role.getcatlist")
    suspend fun getCategoryList(request: GetCategoryListRequest): GetCategoryListResponse

    @POST("role.getrolelist")
    suspend fun getRoleList(request: GetRolesListRequest): GetRolesListResponse

    @POST("user.saveuserrole")
    suspend fun saveUserRole(request: SaveUserRoleRequest): SaveUserRoleResponse

    @POST("user.saveuserunits")
    suspend fun saveUserUnits(request: SaveUserUnitsRequest): SaveUserUnitsResponse

    @POST("vehicle.getvehiclelist")
    suspend fun getVehicleList(request: GetVehicleListRequest): GetVehicleListResponse

    @POST("driver.getdriverlist")
    suspend fun getDriverList(request: GetDriverListRequest): GetDriverListResponse

    @POST("driver.adddriver")
    suspend fun addDriver(request: AddDriverRequest): AddDriverResponse

    @POST("vehicle.addvehicle")
    suspend fun addVehicle(request: AddDriverRequest): AddDriverResponse


}