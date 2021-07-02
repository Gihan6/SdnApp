package com.example.sdnapp.ui.dashboard.vechicle.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.AddVehicleRequest
import com.example.sdnapp.data.networkModels.request.GetVehicleListRequest
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
}