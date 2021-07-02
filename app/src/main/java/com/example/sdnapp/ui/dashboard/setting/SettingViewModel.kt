package com.example.sdnapp.ui.dashboard.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.GetVehicleListRequest
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class SettingViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val _logOut = MutableLiveData<Resource<Boolean>>()
    fun logOut(): LiveData<Resource<Boolean>> {
        return _logOut
    }

    fun logOutFromApp() {
        viewModelScope.launch {
            _logOut.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.clearRepo()
                _logOut.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _logOut.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!$exception"
                    )
                )
            }
        }
    }


}