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
}
