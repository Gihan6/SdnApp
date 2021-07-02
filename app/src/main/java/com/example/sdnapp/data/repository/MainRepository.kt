package com.example.sdnapp.data.repository

import android.util.Log
import com.example.sdnapp.data.api.ApiHelper
import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.db.DataBase
import com.example.sdnapp.db.Repo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject


class MainRepository(private val apiHelper: ApiHelper) : KoinComponent {

    private val dataBase by inject<DataBase>()

    suspend fun getSessionTokenRepo(request: SessionTokenRequest) =
        apiHelper.getSessionToken(request)

    suspend fun getAccountEvent(request: AccountEventRequest) = apiHelper.getAccountEvents(request)

    suspend fun getEventByTags(request: EventsByTagsRequest) =
        apiHelper.getEventByTags(request)


    suspend fun getTagsDashboard(request: TagsDashboardRequest) =
        apiHelper.getTagsDashboard(request)

    suspend fun addCamera(request: AddCameraRequest) =
        apiHelper.addCamera(request)

    suspend fun getCameraList(request: CameraListRequest) =
            apiHelper.getCameraList(request)

    suspend fun updateCamera(request: UpdateCameraRequest) =
            apiHelper.updateCamera(request)

    suspend fun deleteCamera(request: DeleteCameraRequest) =
            apiHelper.deleteCamera(request)

    suspend fun getCameraById(request: CameraByIdRequest) =
            apiHelper.getCameraById(request)

    suspend fun updateSilentMode(request: UpdateSilentModeRequest) =
            apiHelper.updateSilentMode(request)

    suspend fun sendCommand(request: SendCommandRequest) =
            apiHelper.sendCommand(request)

    suspend fun getCommand(request: GetCommandRequest) =
            apiHelper.getCommand(request)

    suspend fun updateCommand(request: UpdateCommandRequest) =
            apiHelper.updateCommand(request)

    suspend fun getLocation(request: GetLocationRequest) =
            apiHelper.getLocation(request)

    suspend fun addNewGeo(request: AddNewGeoRequest) =
            apiHelper.addNewGeo(request)

    suspend fun getGeoLis(request: GetGeoListRequest) =
            apiHelper.getGeoLis(request)

    suspend fun deleteGeo(request: DeleteGeoRequest) =
            apiHelper.deleteGeo(request)

    suspend fun getActivities(request: GetActivitiesRequest) =
            apiHelper.getActivities(request)

    suspend fun getLatActivitiesType(request:GetLatsActivitiesTypesRequest) =
            apiHelper.getLastActivitiesType(request)

    suspend fun getLatActivities(request:GetLastActivitiesRequest) =
            apiHelper.getLastActivities(request)

    suspend fun getUsersList(request:GetUsersListRequest) =
            apiHelper.getUsersList(request)

    suspend fun addUser(request: AddUserRequest) =
            apiHelper.addUser(request)

    suspend fun editUser(request: EditUserRequest) =
            apiHelper.editUser(request)

    suspend fun deleteUser(request: DeleteUserRequest) =
            apiHelper.deleteUser(request)

    suspend fun getCategoryList(request: GetCategoryListRequest) =
            apiHelper.getCategoryList(request)

    suspend fun getRoleList(request: GetRolesListRequest) =
            apiHelper.getRoleList(request)

    suspend fun saveUserRole(request: SaveUserRoleRequest) =
            apiHelper.saveUserRole(request)

    suspend fun saveUserUnits(request: SaveUserUnitsRequest) =
            apiHelper.saveUserUnits(request)

    suspend fun getVehicleList(request: GetVehicleListRequest) =
            apiHelper.getVehicleList(request)

    suspend fun getDriverList(request: GetDriverListRequest) =
            apiHelper.getDriverList(request)

    suspend fun addDriver(request: AddDriverRequest) =
            apiHelper.addDriver(request)

    suspend fun addVehicle(request: AddVehicleRequest) =
            apiHelper.addVehicle(request)
    suspend fun updateDriverVehicle(request: UpdateDriverVehicleRequest) =
            apiHelper.updateDriverVehicle(request)

    suspend fun updateCameraVehicle(request: UpdateCameraVehicleRequest) =
            apiHelper.updateCameraVehicle(request)

    suspend fun accountGroups(request: AccountGroupsRequest) = apiHelper.accountGroups(request)

    suspend fun addAccountGroups(request: AddAccountGroupsRequest) =
            apiHelper.addAccountGroups(request)

    suspend fun updateVehicle(request: UpdateVehicleRequest) = apiHelper.updateVehicle(request)

    suspend fun updateDriver(request: UpdateDriverRequest) =
            apiHelper.updateDriver(request)

    suspend fun groupUnitsInformation(request: GroupUnitsInformationRequest) =
            apiHelper.groupUnitsInformation(request)

    suspend fun updateAccountGroupName(request: UpdateAccountGroupNameRequest) =
            apiHelper.updateAccountGroupName(request)

    suspend fun deleteAccountGroup(request: DeleteAccountGroupRequest) =
            apiHelper.deleteAccountGroup(request)

    suspend fun getUserById(request: GetUserByIdRequest) =
            apiHelper.getUserById(request)

    suspend fun changeUserPassword(request: ChangeUserPasswordRequest) =
            apiHelper.changeUserPassword(request)

    suspend fun getZoneList(request: ZoneListRequest) =
            apiHelper.getZoneList(request)

    suspend fun unitsTrips(request: UnitsTripsRequest) =
            apiHelper.unitsTrips(request)

    suspend fun getTripZones(request: TripZonesRequest) =
            apiHelper.getTripZones(request)

    suspend fun startTrip(request: StartTripRequest) =
            apiHelper.startTrip(request)

    suspend fun endTrip(request: StartTripRequest) =
            apiHelper.endTrip(request)

    suspend fun addDestination(request: AddDestinationRequest) =
            apiHelper.addDestination(request)

    suspend fun deleteStart(request: DeleteStartRequest) =
            apiHelper.deleteStart(request)

    suspend fun deleteEnd(request: DeleteStartRequest) =
            apiHelper.deleteEnd(request)

    suspend fun deleteDestination(request: DeleteStartRequest) =
            apiHelper.deleteDestination(request)

    suspend fun updateDestination(request: UpdateDestinationRequest) =
            apiHelper.updateDestination(request)

    suspend fun getTagsList(request: GetTagsListRequest) =
            apiHelper.getTagsList(request)

    suspend fun saveUser(repo: Repo) {
        try {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                    dataBase.repoDao().insert(repo)
            }
        } catch (e: Exception) {
            Log.e("dataBase", e.toString())
        }
    }
    suspend fun getUser(): Repo? {
        return try {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                dataBase.repoDao().getUser()
            }
        } catch (e: Exception) {
            Log.e("dataBase", e.toString())
            return null
        }
    }

    suspend fun clearRepo(): Boolean {
        var result=false
        try {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                dataBase.repoDao().clear()
                result=true
            }
        } catch (e: Exception) {
            result=false
            Log.e("dataBase", e.toString())
        }
        return  result

    }

//    suspend fun search(keyWord:String): List<Repo> {
//       return try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                dataBase.repoDao().filter(keyWord)
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//           return emptyList<Repo>()
//
//        }
//
//
//    }
}