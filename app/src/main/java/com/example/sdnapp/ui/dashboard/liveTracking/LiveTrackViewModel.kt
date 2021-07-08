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
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class LiveTrackViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val _getConnectionStatus = MutableLiveData<Resource<GetConnectionStatusResponse>>()
    fun getConnectionStatus(): LiveData<Resource<GetConnectionStatusResponse>> {
        return _getConnectionStatus
    }

    fun getConnectionStatusFromWebServices(request: GetConnectionStatusRequest) {
        viewModelScope.launch {
            _getConnectionStatus.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getConnectionStatus(request)

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