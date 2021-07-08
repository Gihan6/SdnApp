package com.example.sdnapp.ui.dashboard.groups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.AccountGroupsRequest
import com.example.sdnapp.data.networkModels.request.AddAccountGroupsRequest
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.AddAccountGroupsResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class GroupsViewModel(private val mainRepository: MainRepository):ViewModel() {


    private val _accountGroups = MutableLiveData<Resource<AccountGroupsResponse>>()
    fun accountGroups(): LiveData<Resource<AccountGroupsResponse>> {
        return _accountGroups
    }

    fun accountGroupsFromWebServices(request: AccountGroupsRequest) {
        viewModelScope.launch {
            _accountGroups.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.accountGroups(request)

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
    //add account groups----------------------------------
    private val _addAccountGroups = MutableLiveData<Resource<AddAccountGroupsResponse>>()
    fun addAccountGroups(): LiveData<Resource<AddAccountGroupsResponse>> {
        return _addAccountGroups
    }

    fun addAccountGroupsFromWebServices(request: AddAccountGroupsRequest) {
        viewModelScope.launch {
            _addAccountGroups.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addAccountGroups(request)

                _addAccountGroups.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _addAccountGroups.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}