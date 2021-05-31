package com.example.sdnapp.data.repository

import com.example.sdnapp.data.api.ApiHelper
import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.db.DataBase
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
//    suspend fun saveRepos(repos: List<Repo>) {
//        try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                for (repo in repos) {
//                    dataBase.repoDao().insert(repo)
//                }
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//        }
//    }

//    suspend fun clearRepo() {
//        try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                dataBase.repoDao().clear()
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//
//        }
//
//
//    }

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