package com.example.sdnapp.ui.dashboard.driver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.UpdateDriverRequest
import com.example.sdnapp.data.networkModels.response.AddDriverResponse
import com.example.sdnapp.data.networkModels.response.GetDriverListResponse
import com.example.sdnapp.data.networkModels.response.UpdateDriverResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.ui.login.LoginActivity
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class DriverViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val _getDriverList = MutableLiveData<Resource<GetDriverListResponse>>()
    fun getDriverList(): LiveData<Resource<GetDriverListResponse>> {
        return _getDriverList
    }

    fun getDriverListFromWebServices() {
        viewModelScope.launch {
            _getDriverList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getDriverList(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid),
                        )

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

    fun addDriverToWebServices(driver_name: String, license_number: String, license_start: String,
                               license_end: String, current_mileage: String) {
        viewModelScope.launch {
            _addDriver.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addDriver(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), driver_name),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_number),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_start),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_end),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), current_mileage),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid)

                )
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

    //deleteDriver----------------------------------
    private val _deleteDriver = MutableLiveData<Resource<AddDriverResponse>>()
    fun deleteDriver(): LiveData<Resource<AddDriverResponse>> {
        return _deleteDriver
    }

    fun deleteDriverFromWebServices(driverId: String) {
        viewModelScope.launch {
            _deleteDriver.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteDriver(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), driverId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid)

                )
                _deleteDriver.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteDriver.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }
    //update Driver----------------------------------
    private val _updateDriver = MutableLiveData<Resource<UpdateDriverResponse>>()
    fun updateDriver(): LiveData<Resource<UpdateDriverResponse>> {
        return _updateDriver
    }

    fun updateDriverToWebServices(driver_name: String, license_number: String, license_start: String,
                                  license_end: String, current_mileage: String,driverId:String) {
        viewModelScope.launch {
            _updateDriver.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateDriver(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), driver_name),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_number),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_start),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_end),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), current_mileage),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), driverId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid)
                )

                _updateDriver.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateDriver.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}