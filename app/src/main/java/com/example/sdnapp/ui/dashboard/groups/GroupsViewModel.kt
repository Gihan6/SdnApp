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
import com.example.sdnapp.ui.login.LoginActivity
import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.example.sdnapp.util.Resource
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class GroupsViewModel(private val mainRepository: MainRepository):ViewModel() {


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
                        RequestBody.create("text/plain".toMediaTypeOrNull(),loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),loggedInUser.userid)
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
    //add account groups----------------------------------
    private val _addAccountGroups = MutableLiveData<Resource<AddAccountGroupsResponse>>()
    fun addAccountGroups(): LiveData<Resource<AddAccountGroupsResponse>> {
        return _addAccountGroups
    }


    fun addAccountGroupsFromWebServices(groupName:String ) {
        viewModelScope.launch {
            _addAccountGroups.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.addAccountGroups(
                        RequestBody.create("text/plain".toMediaTypeOrNull(),groupName),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),""),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(),loggedInUser.userid),
                )

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