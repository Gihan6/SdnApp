package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.*
import okhttp3.RequestBody


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

    suspend fun sendCommand(request: SendCommandRequest) = apiService.sendCommand(request)

    suspend fun getCommand(request: GetCommandRequest) = apiService.getCommand(request)

    suspend fun updateCommand(request: UpdateCommandRequest) = apiService.updateCommand(request)

    suspend fun getLocation(
            start_time: RequestBody, end_time: RequestBody, min_speed: RequestBody, start: RequestBody,
            limit: RequestBody, objectids: RequestBody, playmode: RequestBody, userid: RequestBody,
            token: RequestBody, app_version: RequestBody, _userid: RequestBody
    ) = apiService.getLocation(start_time, end_time, min_speed, start, limit, objectids, playmode, userid,
            token, app_version, _userid)

    suspend fun addNewGeo(request: AddNewGeoRequest) = apiService.addNewGeo(request)

    suspend fun getGeoLis(request: GetGeoListRequest) = apiService.getGeoList(request)

    suspend fun deleteGeo(request: DeleteGeoRequest) = apiService.deleteGeo(request)

    suspend fun getActivities(request: GetActivitiesRequest) = apiService.getActivities(request)

    suspend fun getLastActivitiesType(request: GetLatsActivitiesTypesRequest) =
            apiService.getLastActivitiesTypes(request)

    suspend fun getLastActivities(request:GetLastActivitiesRequest) =
            apiService.getLastActivities(request)

    suspend fun getUsersList(request:GetUsersListRequest) =
            apiService.getUsersList(request)

    suspend fun addUser(request: AddUserRequest) = apiService.addUser(request)

    suspend fun editUser(request: EditUserRequest) = apiService.editUser(request)

    suspend fun deleteUser(request: DeleteUserRequest) = apiService.deleteUser(request)

    suspend fun getCategoryList(request: GetCategoryListRequest) = apiService.getCategoryList(request)

    suspend fun getRoleList(request: GetRolesListRequest) = apiService.getRoleList(request)

    suspend fun saveUserRole(request: SaveUserRoleRequest) = apiService.saveUserRole(request)

    suspend fun saveUserUnits(request: SaveUserUnitsRequest) = apiService.saveUserUnits(request)

    suspend fun getVehicleList(userid: RequestBody, token: RequestBody, app_version: RequestBody,
                               _userid: RequestBody) =
            apiService.getVehicleList(userid, token, app_version, _userid)

    suspend fun getDriverList(userid: RequestBody, token: RequestBody, app_version: RequestBody,
                              _userid: RequestBody) = apiService.getDriverList(userid, token, app_version, _userid)

    suspend fun addDriver(driver_name: RequestBody, license_number: RequestBody, license_start: RequestBody,
                          license_end: RequestBody, current_mileage: RequestBody, userid: RequestBody,
                          token: RequestBody, app_version: RequestBody, _userid: RequestBody) =
            apiService.addDriver(driver_name, license_number, license_start, license_end,
                    current_mileage, userid, token, app_version, _userid)

    suspend fun updateDriver(driver_name: RequestBody, license_number: RequestBody, license_start: RequestBody,
                             license_end: RequestBody, current_mileage: RequestBody,
                             driverId: RequestBody, userid: RequestBody,
                             token: RequestBody, app_version: RequestBody, _userid: RequestBody) =
            apiService.updateDriver(driver_name, license_number, license_start, license_end,
                    current_mileage, driverId, userid, token, app_version, _userid)

    suspend fun deleteDriver(driverId: RequestBody, userid: RequestBody,
                             token: RequestBody, app_version: RequestBody, _userid: RequestBody) =
            apiService.deleteDriver(driverId, userid, token, app_version, _userid)

    suspend fun addVehicle(vehicle_name: RequestBody, plate_no: RequestBody,
                           license_start: RequestBody, license_end: RequestBody,
                           current_mileage: RequestBody, gps_unitid: RequestBody,
                           groupList: RequestBody, max_speed: RequestBody,
                           sim_number: RequestBody,
                           userid: RequestBody, token: RequestBody,
                           app_version: RequestBody, _userid: RequestBody) =
            apiService.addVehicle(vehicle_name, plate_no, license_start, license_end, current_mileage,
                    gps_unitid, groupList, max_speed, sim_number, userid, token,
                    app_version, _userid)

    suspend fun updateDriverVehicle(request: UpdateDriverVehicleRequest) =
            apiService.updateDriverVehicle(request)

    suspend fun updateCameraVehicle(request: UpdateCameraVehicleRequest) =
            apiService.updateCameraVehicle(request)

    suspend fun accountGroups(userid: RequestBody, token: RequestBody,
                              app_version: RequestBody, _userid: RequestBody) =
            apiService.accountGroups(userid, token, app_version, _userid)

    suspend fun addAccountGroups(name: RequestBody,groupid: RequestBody,userid: RequestBody, token: RequestBody,
                                 app_version: RequestBody, _userid: RequestBody) =
            apiService.addAccountGroups(name, groupid, userid, token, app_version, _userid)

    suspend fun updateVehicle(request: UpdateVehicleRequest) =
            apiService.updateVehicle(request)


    suspend fun groupUnitsInformation(request: GroupUnitsInformationRequest) =
            apiService.groupUnitInformation(request)

    suspend fun updateAccountGroupName(name: RequestBody,groupid: RequestBody, userid: RequestBody,
                                       token: RequestBody,
                                       app_version: RequestBody, _userid: RequestBody) =
            apiService.updateAccountGroupName(name,groupid, userid, token, app_version, _userid)

    suspend fun deleteAccountGroup(groupid: RequestBody, userid: RequestBody, token: RequestBody,
                                   app_version: RequestBody, _userid: RequestBody) =
            apiService.deleteAccountGroup(groupid, userid, token, app_version, _userid)

    suspend fun getUserById(request: GetUserByIdRequest) =
            apiService.getUserById(request)

    suspend fun changeUserPassword(request: ChangeUserPasswordRequest) =
            apiService.changeUserPassword(request)

    suspend fun getZoneList(request: ZoneListRequest) =
            apiService.getZoneList(request)

    suspend fun unitsTrips(request: UnitsTripsRequest) =
            apiService.unitsTrips(request)

    suspend fun getTripZones(request: TripZonesRequest) =
            apiService.getTripZones(request)

    suspend fun startTrip(request: StartTripRequest) =
            apiService.startTrip(request)

    suspend fun endTrip(request: StartTripRequest) =
            apiService.endTrip(request)

    suspend fun addDestination(request: AddDestinationRequest) =
            apiService.addDestination(request)

    suspend fun deleteStart(request: DeleteStartRequest) =
            apiService.deleteStart(request)

    suspend fun deleteEnd(request: DeleteStartRequest) =
            apiService.deleteEnd(request)

    suspend fun deleteDestination(request: DeleteStartRequest) =
            apiService.deleteDestination(request)

    suspend fun updateDestination(request: UpdateDestinationRequest) =
            apiService.updateDestination(request)

    suspend fun getTagsList(request: GetTagsListRequest) =
            apiService.getTagsList(request)

    suspend fun getconnectionstatus(userid: RequestBody, token: RequestBody,
                                    app_version: RequestBody, _userid: RequestBody) =
        apiService.getconnectionstatus(userid,token,app_version,_userid)
}