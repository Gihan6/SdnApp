package com.example.sdnapp.ui.dashboard.liveTracking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.response.GetConnectionStatusResponse
import com.example.sdnapp.data.networkModels.response.GetLocationResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.ui.login.LoginActivity
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class LiveTrackViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val _getConnectionStatus = MutableLiveData<Resource<GetConnectionStatusResponse>>()
    fun getConnectionStatus(): LiveData<Resource<GetConnectionStatusResponse>> {
        return _getConnectionStatus
    }

    fun getConnectionStatusFromWebServices() {
        viewModelScope.launch {
            _getConnectionStatus.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getConnectionStatus(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid),

                        )

                _getConnectionStatus.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getConnectionStatus.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //getLocation----------------------------------
    private val _getLocation = MutableLiveData<Resource<GetLocationResponse>>()
    fun getLocation(): LiveData<Resource<GetLocationResponse>> {
        return _getLocation
    }

    fun getLocationFromWebServices(start_time: String, end_time: String,
                                   min_speed: String, start: String,
                                   limit: String, objectids: List<String>,
                                   playmode: Boolean) {
        viewModelScope.launch {
            _getLocation.postValue(Resource.loading(data = null))
            try {


                val response = mainRepository.getLocation(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), start_time),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), end_time),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), min_speed),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), start),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), limit),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), objectids.toString()),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), playmode.toString()),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid),
                )

                _getLocation.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _getLocation.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}