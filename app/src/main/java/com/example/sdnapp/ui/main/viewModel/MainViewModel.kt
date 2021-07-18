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
import okhttp3.RequestBody

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


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

    //addNewGeo----------------------------------
    private val _addNewGeo = MutableLiveData<Resource<AddNewGeoResponse>>()
    fun addNewGeo(): LiveData<Resource<AddNewGeoResponse>> {
        return _addNewGeo
    }

    fun addNewGeoToWebServices(request: AddNewGeoRequest) {
        viewModelScope.launch {
            _addNewGeo.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addNewGeo(request)

                _addNewGeo.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addNewGeo.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getGeoList----------------------------------
    private val _getGeoList = MutableLiveData<Resource<GetGeoListResponse>>()
    fun getGeoList(): LiveData<Resource<GetGeoListResponse>> {
        return _getGeoList
    }

    fun getGeoListFromWebServices(request: GetGeoListRequest) {
        viewModelScope.launch {
            _getGeoList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getGeoLis(request)

                _getGeoList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getGeoList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //deleteGeo----------------------------------
    private val _deleteGeo = MutableLiveData<Resource<DeleteGeoResponse>>()
    fun deleteGeo(): LiveData<Resource<DeleteGeoResponse>> {
        return _deleteGeo
    }

    fun deleteGeoFromWebServices(request: DeleteGeoRequest) {
        viewModelScope.launch {
            _deleteGeo.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteGeo(request)

                _deleteGeo.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteGeo.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getActivities----------------------------------
    private val _getActivities = MutableLiveData<Resource<GetActivitiesResponse>>()
    fun getActivities(): LiveData<Resource<GetActivitiesResponse>> {
        return _getActivities
    }

    fun getActivitiesFromWebServices(request: GetActivitiesRequest) {
        viewModelScope.launch {
            _getActivities.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getActivities(request)

                _getActivities.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getActivities.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getLastActivitiesTypes----------------------------------
    private val _getLastActivitiesTypes = MutableLiveData<Resource<GetLatsActivitiesTypesResponse>>()
    fun getLastActivitiesTypes(): LiveData<Resource<GetLatsActivitiesTypesResponse>> {
        return _getLastActivitiesTypes
    }

    fun getLastActivitiesTypesFromWebServices(request: GetLatsActivitiesTypesRequest) {
        viewModelScope.launch {
            _getLastActivitiesTypes.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getLatActivitiesType(request)

                _getLastActivitiesTypes.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getLastActivitiesTypes.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getLastActivities----------------------------------
    private val _getLastActivities = MutableLiveData<Resource<GetLastActivitiesResponse>>()
    fun getLastActivities(): LiveData<Resource<GetLastActivitiesResponse>> {
        return _getLastActivities
    }

    fun getLastActivitiesFromWebServices(request: GetLastActivitiesRequest) {
        viewModelScope.launch {
            _getLastActivities.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getLatActivities(request)

                _getLastActivities.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getLastActivities.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getUsersList----------------------------------
    private val _getUsersList = MutableLiveData<Resource<GetUsersListResponse>>()
    fun getUsersList(): LiveData<Resource<GetUsersListResponse>> {
        return _getUsersList
    }

    fun getUsersListFromWebServices(request: GetUsersListRequest) {
        viewModelScope.launch {
            _getUsersList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getUsersList(request)

                _getUsersList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getUsersList.postValue(
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




    //updateDriverVehicle----------------------------------
    private val _updateDriverVehicle = MutableLiveData<Resource<UpdateDriverVehicleResponse>>()
    fun updateDriverVehicle(): LiveData<Resource<UpdateDriverVehicleResponse>> {
        return _updateDriverVehicle
    }

    fun updateDriverVehicleToWebServices(request: UpdateDriverVehicleRequest) {
        viewModelScope.launch {
            _updateDriverVehicle.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateDriverVehicle(request)

                _updateDriverVehicle.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateDriverVehicle.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //updateCameraVehicle----------------------------------
    private val _updateCameraVehicle = MutableLiveData<Resource<UpdateCameraVehicleResponse>>()
    fun updateCameraVehicle(): LiveData<Resource<UpdateCameraVehicleResponse>> {
        return _updateCameraVehicle
    }

    fun updateCameraVehicleToWebServices(request: UpdateCameraVehicleRequest) {
        viewModelScope.launch {
            _updateCameraVehicle.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateCameraVehicle(request)

                _updateCameraVehicle.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateCameraVehicle.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }


    //update vehicle----------------------------------
    private val _updateVehicle = MutableLiveData<Resource<UpdateVehicleResponse>>()
    fun updateVehicle(): LiveData<Resource<UpdateVehicleResponse>> {
        return _updateVehicle
    }

    fun updateVehicleToWebServices(request: UpdateVehicleRequest) {
        viewModelScope.launch {
            _updateVehicle.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateVehicle(request)

                _updateVehicle.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateVehicle.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }


    //GroupUnitsInformation----------------------------------
    private val _groupUnitsInformation = MutableLiveData<Resource<GroupUnitsInformationResponse>>()
    fun groupUnitsInformation(): LiveData<Resource<GroupUnitsInformationResponse>> {
        return _groupUnitsInformation
    }

    fun getGroupUnitsInformationFromWebServices(request: GroupUnitsInformationRequest) {
        viewModelScope.launch {
            _groupUnitsInformation.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.groupUnitsInformation(request)

                _groupUnitsInformation.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _groupUnitsInformation.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }


    //getUSerById----------------------------------
    private val _getUSerById = MutableLiveData<Resource<GetUserByIdResponse>>()
    fun getUSerById(): LiveData<Resource<GetUserByIdResponse>> {
        return _getUSerById
    }

    fun getUSerByIdFromWebServices(request: GetUserByIdRequest) {
        viewModelScope.launch {
            _getUSerById.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getUserById(request)

                _getUSerById.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getUSerById.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //changeUserPassword----------------------------------
    private val _changeUserPassword = MutableLiveData<Resource<ChangeUserPasswordResponse>>()
    fun changeUserPassword(): LiveData<Resource<ChangeUserPasswordResponse>> {
        return _changeUserPassword
    }

    fun changeUserPasswordFromWebServices(request: ChangeUserPasswordRequest) {
        viewModelScope.launch {
            _changeUserPassword.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.changeUserPassword(request)

                _changeUserPassword.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _changeUserPassword.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //Get Zone List----------------------------------
    private val _getZoneList = MutableLiveData<Resource<ZoneListResponse>>()
    fun getZoneList(): LiveData<Resource<ZoneListResponse>> {
        return _getZoneList
    }

    fun getZoneListFromWebServices(request: ZoneListRequest) {
        viewModelScope.launch {
            _getZoneList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getZoneList(request)

                _getZoneList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getZoneList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }


    //Get Units trips----------------------------------
    private val _unitsTrips = MutableLiveData<Resource<UnitsTripsResponse>>()
    fun getUnitsTrips(): LiveData<Resource<UnitsTripsResponse>> {
        return _unitsTrips
    }

    fun getUnitsTripsFromWebServices(request: UnitsTripsRequest) {
        viewModelScope.launch {
            _unitsTrips.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.unitsTrips(request)

                _unitsTrips.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _unitsTrips.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //Get trip zones----------------------------------
    private val _tripZones = MutableLiveData<Resource<TripZonesResponse>>()
    fun getTripZones(): LiveData<Resource<TripZonesResponse>> {
        return _tripZones
    }

    fun getTripZonesFromWebServices(request: TripZonesRequest) {
        viewModelScope.launch {
            _tripZones.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getTripZones(request)

                _tripZones.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _tripZones.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //start trip----------------------------------
    private val _startTrip = MutableLiveData<Resource<StartTripResponse>>()
    fun startTrip(): LiveData<Resource<StartTripResponse>> {
        return _startTrip
    }

    fun startTripFromWebServices(request: StartTripRequest) {
        viewModelScope.launch {
            _startTrip.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.startTrip(request)

                _startTrip.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _startTrip.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //start trip----------------------------------
    private val _endTrip = MutableLiveData<Resource<StartTripResponse>>()
    fun endTrip(): LiveData<Resource<StartTripResponse>> {
        return _endTrip
    }

    fun endTripFromWebServices(request: StartTripRequest) {
        viewModelScope.launch {
            _endTrip.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.endTrip(request)

                _endTrip.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _endTrip.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //start trip----------------------------------
    private val _addDestination = MutableLiveData<Resource<AddDestinationResponse>>()
    fun addDestination(): LiveData<Resource<AddDestinationResponse>> {
        return _addDestination
    }

    fun addDestinationToWebServices(request: AddDestinationRequest) {
        viewModelScope.launch {
            _addDestination.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addDestination(request)

                _addDestination.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addDestination.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //delete start----------------------------------
    private val _deleteStart = MutableLiveData<Resource<DeleteStartResponse>>()
    fun deleteStart(): LiveData<Resource<DeleteStartResponse>> {
        return _deleteStart
    }

    fun deleteStartFromWebServices(request: DeleteStartRequest) {
        viewModelScope.launch {
            _deleteStart.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteStart(request)

                _deleteStart.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteStart.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //delete end----------------------------------
    private val _deleteEnd = MutableLiveData<Resource<DeleteStartResponse>>()
    fun deleteEnd(): LiveData<Resource<DeleteStartResponse>> {
        return _deleteEnd
    }

    fun deleteEndFromWebServices(request: DeleteStartRequest) {
        viewModelScope.launch {
            _deleteEnd.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteEnd(request)

                _deleteEnd.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteEnd.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //delete Destination----------------------------------
    private val _deleteDestination = MutableLiveData<Resource<DeleteStartResponse>>()
    fun deleteDestination(): LiveData<Resource<DeleteStartResponse>> {
        return _deleteDestination
    }

    fun deleteDestinationFromWebServices(request: DeleteStartRequest) {
        viewModelScope.launch {
            _deleteDestination.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteDestination(request)

                _deleteDestination.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteDestination.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //update Destination----------------------------------
    private val _updateDestination = MutableLiveData<Resource<UpdateDestinationResponse>>()
    fun updateDestination(): LiveData<Resource<UpdateDestinationResponse>> {
        return _updateDestination
    }

    fun updateDestinationFromWebServices(request: UpdateDestinationRequest) {
        viewModelScope.launch {
            _updateDestination.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateDestination(request)

                _updateDestination.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateDestination.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //get tags list----------------------------------
    private val _getTagsList = MutableLiveData<Resource<GetTagsListResponse>>()
    fun getTagsList(): LiveData<Resource<GetTagsListResponse>> {
        return _getTagsList
    }

    fun getTagsListFromWebServices(request: GetTagsListRequest) {
        viewModelScope.launch {
            _getTagsList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getTagsList(request)

                _getTagsList.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getTagsList.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}
