package com.example.sdnapp.ui.main.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.*
import com.example.sdnapp.data.networkModels.response.*
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val sessionToken = MutableLiveData<Resource<SessionTokenResponse>>()
    fun getSessionToken(): LiveData<Resource<SessionTokenResponse>> {
        return sessionToken
    }

    fun getSessionTokenFromWebServices(request: SessionTokenRequest) {
        viewModelScope.launch {
            sessionToken.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getSessionTokenRepo(request)

                sessionToken.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                sessionToken.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //------getAccountEvent
    private val accountEvent = MutableLiveData<Resource<AccountEventResponse>>()
    fun getAccountEvent(): LiveData<Resource<AccountEventResponse>> {
        return accountEvent
    }

    fun getAccountEventFromWebServices(request: AccountEventRequest) {
        viewModelScope.launch {
            accountEvent.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getAccountEvent(request)

                accountEvent.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                accountEvent.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //get Event by Tags----------------------------------
    private val eventByTags = MutableLiveData<Resource<EventsByTagsResponse>>()
    fun getEventByTags(): LiveData<Resource<EventsByTagsResponse>> {
        return eventByTags
    }

    fun getEventByTagsFromWebServices(request: EventsByTagsRequest) {
        viewModelScope.launch {
            eventByTags.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getEventByTags(request)

                eventByTags.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                eventByTags.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getTagsDashboard----------------------------------
    private val tagsDashboard = MutableLiveData<Resource<TagsDashboardResponse>>()
    fun getTagsDashboard(): LiveData<Resource<TagsDashboardResponse>> {
        return tagsDashboard
    }

    fun getTagsDashboardFromWebServices(request: TagsDashboardRequest) {
        viewModelScope.launch {
            tagsDashboard.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getTagsDashboard(request)

                tagsDashboard.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                tagsDashboard.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }


    //addCamera----------------------------------
    private val addCamera = MutableLiveData<Resource<AddCameraResponse>>()
    fun addCamera(): LiveData<Resource<AddCameraResponse>> {
        return addCamera
    }

    fun addCameraToWebServices(request: AddCameraRequest) {
        viewModelScope.launch {
            addCamera.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addCamera(request)

                addCamera.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                addCamera.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getCameraList----------------------------------
    private val cameraList = MutableLiveData<Resource<CameraListResponse>>()
    fun getCameraList(): LiveData<Resource<CameraListResponse>> {
        return cameraList
    }

    fun getCameraListFromWebServices(request: CameraListRequest) {
        viewModelScope.launch {
            cameraList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getCameraList(request)

                cameraList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                cameraList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //updateCamera----------------------------------
    private val updateCamera = MutableLiveData<Resource<UpdateCameraResponse>>()
    fun updateCameraStatus(): LiveData<Resource<UpdateCameraResponse>> {
        return updateCamera
    }

    fun updateCameraFromWebServices(request: UpdateCameraRequest) {
        viewModelScope.launch {
            updateCamera.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateCamera(request)

                updateCamera.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                updateCamera.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //updateCamera----------------------------------
    private val _deleteCamera = MutableLiveData<Resource<DeleteCameraResponse>>()
    fun deleteCamera(): LiveData<Resource<DeleteCameraResponse>> {
        return _deleteCamera
    }

    fun deleteCameraFromWebServices(request: DeleteCameraRequest) {
        viewModelScope.launch {
            _deleteCamera.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteCamera(request)

                _deleteCamera.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteCamera.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getCameraById----------------------------------
    private val _getCameraById = MutableLiveData<Resource<CameraByIdResponse>>()
    fun getCameraById(): LiveData<Resource<CameraByIdResponse>> {
        return _getCameraById
    }

    fun getCameraByIdFromWebServices(request: CameraByIdRequest) {
        viewModelScope.launch {
            _getCameraById.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getCameraById(request)

                _getCameraById.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getCameraById.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
    //updateSilentMode----------------------------------
    private val _updateSilentMode = MutableLiveData<Resource<UpdateSilentModeResponse>>()
    fun updateSilentMode(): LiveData<Resource<UpdateSilentModeResponse>> {
        return _updateSilentMode
    }

    fun updateSilentModeFromWebServices(request: UpdateSilentModeRequest) {
        viewModelScope.launch {
            _updateSilentMode.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateSilentMode(request)

                _updateSilentMode.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateSilentMode.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
    //sendCommand----------------------------------
    private val _sendCommand = MutableLiveData<Resource<SendCommandResponse>>()
    fun sendCommand(): LiveData<Resource<SendCommandResponse>> {
        return _sendCommand
    }

    fun sendCommandToWebServices(request: SendCommandRequest) {
        viewModelScope.launch {
            _sendCommand.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.sendCommand(request)

                _sendCommand.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _sendCommand.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
    //getCommand----------------------------------
    private val _getCommand = MutableLiveData<Resource<GetCommandResponse>>()
    fun getCommand(): LiveData<Resource<GetCommandResponse>> {
        return _getCommand
    }

    fun getCommandFromWebServices(request: GetCommandRequest) {
        viewModelScope.launch {
            _getCommand.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getCommand(request)

                _getCommand.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getCommand.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
    //updateCommand----------------------------------
    private val _updateCommand = MutableLiveData<Resource<UpdateCommandResponse>>()
    fun updateCommand(): LiveData<Resource<UpdateCommandResponse>> {
        return _updateCommand
    }

    fun updateCommandFromWebServices(request: UpdateCommandRequest) {
        viewModelScope.launch {
            _updateCommand.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateCommand(request)

                _updateCommand.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateCommand.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //addUser----------------------------------
    private val _addUser = MutableLiveData<Resource<AddUserResponse>>()
    fun addUSer(): LiveData<Resource<AddUserResponse>> {
        return _addUser
    }

    fun addUserToWebServices(request: AddUserRequest) {
        viewModelScope.launch {
            _addUser.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addUser(request)

                _addUser.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addUser.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //editUser----------------------------------
    private val _editUser = MutableLiveData<Resource<EditUserResponse>>()
    fun editUSer(): LiveData<Resource<EditUserResponse>> {
        return _editUser
    }

    fun editUserToWebServices(request: EditUserRequest) {
        viewModelScope.launch {
            _editUser.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.editUser(request)

                _editUser.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _editUser.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //deleteUser----------------------------------
    private val _deleteUser = MutableLiveData<Resource<DeleteUserResponse>>()
    fun deleteUSer(): LiveData<Resource<DeleteUserResponse>> {
        return _deleteUser
    }

    fun deleteUserFromWebServices(request: DeleteUserRequest) {
        viewModelScope.launch {
            _deleteUser.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteUser(request)

                _deleteUser.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteUser.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getCategoryList----------------------------------
    private val _categoryList = MutableLiveData<Resource<GetCategoryListResponse>>()
    fun getCategoryList(): LiveData<Resource<GetCategoryListResponse>> {
        return _categoryList
    }

    fun getCategoryListFromWebServices(request: GetCategoryListRequest) {
        viewModelScope.launch {
            _categoryList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getCategoryList(request)

                _categoryList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _categoryList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getRoleList----------------------------------
    private val _roleList = MutableLiveData<Resource<GetRolesListResponse>>()
    fun getRoleList(): LiveData<Resource<GetRolesListResponse>> {
        return _roleList
    }

    fun getRoleListFromWebServices(request: GetRolesListRequest) {
        viewModelScope.launch {
            _roleList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getRoleList(request)

                _roleList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _roleList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //saveUserRole----------------------------------
    private val _saveUserRole = MutableLiveData<Resource<SaveUserRoleResponse>>()
    fun saveUserRole(): LiveData<Resource<SaveUserRoleResponse>> {
        return _saveUserRole
    }

    fun saveUserRoleToWebServices(request: SaveUserRoleRequest) {
        viewModelScope.launch {
            _saveUserRole.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.saveUserRole(request)

                _saveUserRole.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _saveUserRole.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //saveUserUnit----------------------------------
    private val _saveUserUnits = MutableLiveData<Resource<SaveUserUnitsResponse>>()
    fun saveUserUnits(): LiveData<Resource<SaveUserUnitsResponse>> {
        return _saveUserUnits
    }

    fun saveUserUnitsToWebServices(request: SaveUserUnitsRequest) {
        viewModelScope.launch {
            _saveUserUnits.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.saveUserUnits(request)

                _saveUserUnits.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _saveUserUnits.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getVehicleUnit----------------------------------
    private val _getVehicleList = MutableLiveData<Resource<GetVehicleListResponse>>()
    fun getVehicleList(): LiveData<Resource<GetVehicleListResponse>> {
        return _getVehicleList
    }

    fun getVehicleListFromWebServices(request: GetVehicleListRequest) {
        viewModelScope.launch {
            _getVehicleList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getVehicleList(request)

                _getVehicleList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getVehicleList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getDriverList----------------------------------
    private val _getDriverList = MutableLiveData<Resource<GetDriverListResponse>>()
    fun getDriverList(): LiveData<Resource<GetDriverListResponse>> {
        return _getDriverList
    }

    fun getDriverListFromWebServices(request: GetDriverListRequest) {
        viewModelScope.launch {
            _getDriverList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getDriverList(request)

                _getDriverList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getDriverList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //addDriver----------------------------------
    private val _addDriver = MutableLiveData<Resource<AddDriverResponse>>()
    fun addDriver(): LiveData<Resource<AddDriverResponse>> {
        return _addDriver
    }

    fun addDriverToWebServices(request: AddDriverRequest) {
        viewModelScope.launch {
            _addDriver.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addDriver(request)

                _addDriver.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addDriver.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
}
