package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.data.networkModels.response.*
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


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

    @POST("location.getlocation")
    suspend fun getLocation(request: GetLocationRequest): GetLocationResponse

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

    @POST("vehicle.getvehiclelist")
    @Headers("Content-Type: application/json")
    suspend fun getVehicleList(@Body request: GetVehicleListRequest): GetVehicleListResponse

    @POST("driver.getdriverlist")
    @Headers("Content-Type: application/json")
    suspend fun getDriverList(@Body request: GetDriverListRequest): GetDriverListResponse

    @POST("driver.adddriver")
    @Headers("Content-Type: application/json")
    suspend fun addDriver(@Body request: AddDriverRequest): AddDriverResponse

    @POST("vehicle.addvehicle")
    @Headers("Content-Type: application/json")
    suspend fun addVehicle(@Body request: AddVehicleRequest): AddVehicleResponse

    @POST("driver.updatedrivervehicle")
    suspend fun updateDriverVehicle(request: UpdateDriverVehicleRequest):
            UpdateDriverVehicleResponse

    @POST("cam.updatecamvehicle")
    suspend fun updateCameraVehicle(request: UpdateCameraVehicleRequest):
            UpdateCameraVehicleResponse

    @Headers("Content-Type: application/json")
    @POST("groups.accountGroups")
    suspend fun accountGroups(@Body request: AccountGroupsRequest): AccountGroupsResponse

    @Headers("Content-Type: application/json")
    @POST("groups.addAccountGroups")
    suspend fun addAccountGroups(@Body request: AddAccountGroupsRequest): AddAccountGroupsResponse

    @POST("vehicle.updatevehicle")
    suspend fun updateVehicle(request: UpdateVehicleRequest): UpdateVehicleResponse

    @POST("driver.updatedriver")
    suspend fun updateDriver(request: UpdateDriverRequest): UpdateDriverResponse

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



    @POST("location.getconnectionstatus")
    @Headers("Content-Type: application/json")
    suspend fun getconnectionstatus(@Body request: GetConnectionStatusRequest): GetConnectionStatusResponse




}