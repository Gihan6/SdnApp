package com.example.sdnapp.ui.dashboard.vechicle.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.AddVehicleRequest
import com.example.sdnapp.data.networkModels.request.GetVehicleListRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.AddVehicleResponse
import com.example.sdnapp.data.networkModels.response.GetVehicleListResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class VehicleViewModel(private val mainRepository: MainRepository) : ViewModel() {


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

    //addVehicle----------------------------------
    private val _addVehicle = MutableLiveData<Resource<AddVehicleResponse>>()
    fun addVehicle(): LiveData<Resource<AddVehicleResponse>> {
        return _addVehicle
    }

    fun addVehicleToWebServices(request: AddVehicleRequest) {
        viewModelScope.launch {
            _addVehicle.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addVehicle(request)

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
                val response = mainRepository.accountGroups("-200",
                        "25d48e686a35c064ca36e55bd0a6d95f", "49",
                        "98af3d52110566829f75bc928aa0ee7b")

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