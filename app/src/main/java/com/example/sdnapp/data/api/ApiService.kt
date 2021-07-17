package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.data.networkModels.response.*
import okhttp3.RequestBody
import retrofit2.http.*


interface ApiService {

    @POST("user.getsessiontoken")
    @Headers("Content-Type: application/json")
    suspend fun getSessionToken(@Body request: SessionTokenRequest): SessionTokenResponse

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

    @Multipart
    @POST("location.getlocation")
    suspend fun getLocation(
            @Part("start_time") start_time: RequestBody,
            @Part("end_time") end_time: RequestBody,
            @Part("min_speed") min_speed: RequestBody,
            @Part("start") start: RequestBody,
            @Part("limit") limit: RequestBody,
            @Part("objectids") objectids: RequestBody,
            @Part("playmode") playmode: RequestBody,
            @Part("userid") userid: RequestBody,
            @Part("token") token: RequestBody,
            @Part("app_version") app_version: RequestBody,
            @Part("_userid") _userid: RequestBody,
    ): GetLocationResponse

    @POST("geofence.add")
    suspend fun addNewGeo(request: AddNewGeoRequest): AddNewGeoResponse

    @POST("geofence.list")
    suspend fun getGeoList(request: GetGeoListRequest): GetGeoListResponse

    @POST("geofence.delete")
    suspend fun deleteGeo(request: DeleteGeoRequest): DeleteGeoResponse

    @POST("activity.getActivites")
    suspend fun getActivities(request: GetActivitiesRequest): GetActivitiesResponse

    @POST("activity.getLastActivitesTypes")
    suspend fun getLastActivitiesTypes(request: GetLatsActivitiesTypesRequest):
            GetLatsActivitiesTypesResponse

    @POST("aactivity.getLastActivites")
    suspend fun getLastActivities(request: GetLastActivitiesRequest): GetLastActivitiesResponse

    @POST("account.getuserslist")
    suspend fun getUsersList(request: GetUsersListRequest): GetUsersListResponse

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

    @Multipart
    @POST("vehicle.getvehiclelist")
    suspend fun getVehicleList(@Part("userid") userid: RequestBody,
                               @Part("token") token: RequestBody,
                               @Part("app_version") app_version: RequestBody,
                               @Part("_userid") _userid: RequestBody): GetVehicleListResponse

    @Multipart
    @POST("driver.getdriverlist")
    suspend fun getDriverList(@Part("userid") userid: RequestBody,
                              @Part("token") token: RequestBody,
                              @Part("app_version") app_version: RequestBody,
                              @Part("_userid") _userid: RequestBody): GetDriverListResponse

    @Multipart
    @POST("driver.adddriver")
    suspend fun addDriver(
            @Part("driver_name") driver_name: RequestBody,
            @Part("license_number") license_number: RequestBody,
            @Part("license_start") license_start: RequestBody,
            @Part("license_end") license_end: RequestBody,
            @Part("current_mileage") current_mileage: RequestBody,
            @Part("userid") userid: RequestBody,
            @Part("token") token: RequestBody,
            @Part("app_version") app_version: RequestBody,
            @Part("_userid") _userid: RequestBody): AddDriverResponse

    @Multipart
    @POST("driver.updatedriver")
    suspend fun updateDriver(@Part("driver_name") driver_name: RequestBody,
                             @Part("license_number") license_number: RequestBody,
                             @Part("license_start") license_start: RequestBody,
                             @Part("license_end") license_end: RequestBody,
                             @Part("current_mileage") current_mileage: RequestBody,
                             @Part("driverid") driverid: RequestBody,
                             @Part("userid") userid: RequestBody,
                             @Part("token") token: RequestBody,
                             @Part("app_version") app_version: RequestBody,
                             @Part("_userid") _userid: RequestBody): UpdateDriverResponse

    @Multipart
    @POST("driver.deletedriver")
    suspend fun deleteDriver(
            @Part("driverid") driverid: RequestBody,
            @Part("userid") userid: RequestBody,
            @Part("token") token: RequestBody,
            @Part("app_version") app_version: RequestBody,
            @Part("_userid") _userid: RequestBody): AddDriverResponse

    @POST("vehicle.addvehicle")
    @Headers("Content-Type: application/json")
    suspend fun addVehicle(@Body request: AddVehicleRequest): AddVehicleResponse

    @POST("driver.updatedrivervehicle")
    suspend fun updateDriverVehicle(request: UpdateDriverVehicleRequest):
            UpdateDriverVehicleResponse

    @POST("cam.updatecamvehicle")
    suspend fun updateCameraVehicle(request: UpdateCameraVehicleRequest):
            UpdateCameraVehicleResponse

    @Multipart
    @POST("groups.accountGroups")
    suspend fun accountGroups(@Part("userid") userid: RequestBody,
                              @Part("token") token: RequestBody,
                              @Part("app_version") app_version: RequestBody,
                              @Part("_userid") _userid: RequestBody): AccountGroupsResponse

    @Multipart
    @POST("groups.addAccountGroup")
    suspend fun addAccountGroups(@Part("name") name: RequestBody,
                                 @Part("groupid") groupid: RequestBody,
                                 @Part("userid") userid: RequestBody,
                                 @Part("token") token: RequestBody,
                                 @Part("app_version") app_version: RequestBody,
                                 @Part("_userid") _userid: RequestBody): AddAccountGroupsResponse

    @POST("vehicle.updatevehicle")
    suspend fun updateVehicle(request: UpdateVehicleRequest): UpdateVehicleResponse


    @POST("groups.groupUnitsInformation")
    suspend fun groupUnitInformation(request: GroupUnitsInformationRequest):
            GroupUnitsInformationResponse

    @POST("groups.updateAccountGroupName")
    suspend fun updateAccountGroupName(request: UpdateAccountGroupNameRequest):
            UpdateAccountGroupNameResponse

    @POST("groups.deleteAccountGroup")
    suspend fun deleteAccountGroup(request: DeleteAccountGroupRequest):
            DeleteAccountGroupResponse

    @POST("user.getuserbyid")
    suspend fun getUserById(request: GetUserByIdRequest): GetUserByIdResponse

    @POST("user.changeuserpassword")
    suspend fun changeUserPassword(request: ChangeUserPasswordRequest): ChangeUserPasswordResponse

    @POST("trip.zoneList")
    suspend fun getZoneList(request: ZoneListRequest): ZoneListResponse

    @POST("trip.unitsTrips")
    suspend fun unitsTrips(request: UnitsTripsRequest): UnitsTripsResponse

    @POST("trip.tripZones")
    suspend fun getTripZones(request: TripZonesRequest): TripZonesResponse

    @POST("trip.addStarter")
    suspend fun startTrip(request: StartTripRequest): StartTripResponse

    @POST("trip.addCloser")
    suspend fun endTrip(request: StartTripRequest): StartTripResponse

    @POST("trip.addDestination")
    suspend fun addDestination(request: AddDestinationRequest): AddDestinationResponse

    @POST("trip.deleteStarter")
    suspend fun deleteStart(request: DeleteStartRequest): DeleteStartResponse

    @POST("/trip.deleteCloser")
    suspend fun deleteEnd(request: DeleteStartRequest): DeleteStartResponse

    @POST("trip.deleteDestination")
    suspend fun deleteDestination(request: DeleteStartRequest): DeleteStartResponse

    @POST("trip.updateDestination")
    suspend fun updateDestination(request: UpdateDestinationRequest): UpdateDestinationResponse

    @POST("event.gettagslist")
    suspend fun getTagsList(request: GetTagsListRequest): GetTagsListResponse


    @Multipart
    @POST("location.getconnectionstatus")
    suspend fun getconnectionstatus(@Part("userid") userid: RequestBody,
                                    @Part("token") token: RequestBody,
                                    @Part("app_version") app_version: RequestBody,
                                    @Part("_userid") _userid: RequestBody): GetConnectionStatusResponse




}