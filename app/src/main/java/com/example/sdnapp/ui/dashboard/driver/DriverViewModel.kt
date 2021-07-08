package com.example.sdnapp.ui.dashboard.driver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.AddDriverRequest
import com.example.sdnapp.data.networkModels.request.GetDriverListRequest
import com.example.sdnapp.data.networkModels.response.AddDriverResponse
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class DriverViewModel(private val mainRepository: MainRepository) : ViewModel() {


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