package com.example.sdnapp.ui.dashboard.liveTracking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.GetConnectionStatusRequest
import com.example.sdnapp.data.networkModels.request.GetTagsListRequest
import com.example.sdnapp.data.networkModels.response.GetConnectionStatusResponse
import com.example.sdnapp.data.networkModels.response.GetTagsListResponse
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

}