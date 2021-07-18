package com.example.sdnapp.ui.dashboard.vechicle.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.AddVehicleResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.ui.login.LoginActivity
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class VehicleViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val _getVehicleList = MutableLiveData<Resource<GetVehicleListResponse>>()
    fun getVehicleList(): LiveData<Resource<GetVehicleListResponse>> {
        return _getVehicleList
    }

    fun getVehicleListFromWebServices() {
        viewModelScope.launch {
            _getVehicleList.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getVehicleList(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid)


                )
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

    //addVehicle----------------------------------
    private val _addVehicle = MutableLiveData<Resource<AddVehicleResponse>>()
    fun addVehicle(): LiveData<Resource<AddVehicleResponse>> {
        return _addVehicle
    }

    fun addVehicleToWebServices(vehicle_name: String, plate_no: String,
                                license_start: String, license_end: String,
                                current_mileage: String, gps_unitid: String,
                                groupList: List<String>, max_speed: String,
                                sim_number: String
    ) {
        viewModelScope.launch {
            _addVehicle.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addVehicle(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), vehicle_name),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), plate_no),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_start),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), license_end),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), current_mileage),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), gps_unitid),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), groupList.toString()),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), max_speed),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), sim_number),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId)
                )

                _addVehicle.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addVehicle.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!$exception"
                    )
                )
            }
        }
    }

    //account groups----------------------------------
    private val _accountGroups = MutableLiveData<Resource<AccountGroupsResponse>>()
    fun accountGroups(): LiveData<Resource<AccountGroupsResponse>> {
        return _accountGroups
    }

    fun accountGroupsFromWebServices() {
        viewModelScope.launch {
            _accountGroups.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.accountGroups(
                        RequestBody.create("text/plain".toMediaTypeOrNull(),LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.loggedInUser.userid),
                )

                _accountGroups.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _accountGroups.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}