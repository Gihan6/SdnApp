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

    suspend fun sendCommand(request: SendCommandRequest) = apiService.sendCommand(request)

    suspend fun getCommand(request: GetCommandRequest) = apiService.getCommand(request)

    suspend fun updateCommand(request: UpdateCommandRequest) = apiService.updateCommand(request)

    suspend fun getLocation(request: GetLocationRequest) = apiService.getLocation(request)

    suspend fun addNewGeo(request: AddNewGeoRequest) = apiService.addNewGeo(request)

    suspend fun getGeoLis(request: GetGeoListRequest) = apiService.getGeoList(request)

    suspend fun deleteGeo(request: DeleteGeoRequest) = apiService.deleteGeo(request)

    suspend fun getActivities(request: GetActivitiesRequest) = apiService.getActivities(request)

    suspend fun getLastActivitiesType(request:GetLatsActivitiesTypesRequest) =
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

    suspend fun getVehicleList(request: GetVehicleListRequest) = apiService.getVehicleList(request)

    suspend fun getDriverList(request: GetDriverListRequest) = apiService.getDriverList(request)

    suspend fun addDriver(request: AddDriverRequest) = apiService.addDriver(request)

    suspend fun addVehicle(request: AddVehicleRequest) = apiService.addVehicle(request)

    suspend fun updateDriverVehicle(request: UpdateDriverVehicleRequest) =
            apiService.updateDriverVehicle(request)

    suspend fun updateCameraVehicle(request: UpdateCameraVehicleRequest) =
            apiService.updateCameraVehicle(request)

    suspend fun accountGroups(request: AccountGroupsRequest) = apiService.accountGroups(request)

    suspend fun addAccountGroups(request: AddAccountGroupsRequest) =
            apiService.addAccountGroups(request)

    suspend fun updateVehicle(request: UpdateVehicleRequest) =
            apiService.updateVehicle(request)

    suspend fun updateDriver(request: UpdateDriverRequest) =
            apiService.updateDriver(request)

    suspend fun groupUnitsInformation(request: GroupUnitsInformationRequest) =
            apiService.groupUnitInformation(request)

    suspend fun updateAccountGroupName(request: UpdateAccountGroupNameRequest) =
            apiService.updateAccountGroupName(request)

    suspend fun deleteAccountGroup(request: DeleteAccountGroupRequest) =
            apiService.deleteAccountGroup(request)

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
}