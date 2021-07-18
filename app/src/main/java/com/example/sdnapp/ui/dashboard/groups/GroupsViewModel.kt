package com.example.sdnapp.ui.dashboard.groups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.response.AccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.AddAccountGroupsResponse
import com.example.sdnapp.data.networkModels.response.DeleteAccountGroupResponse
import com.example.sdnapp.data.networkModels.response.UpdateAccountGroupNameResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.ui.login.LoginActivity
import com.example.sdnapp.ui.login.LoginActivity.Companion.loggedInUser
import com.example.sdnapp.util.Resource
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
                        RequestBody.create("text/plain".toMediaTypeOrNull(), groupName),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), ""),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.userid),
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

    //deleteAccount----------------------------------
    private val _deleteAccountGroupName = MutableLiveData<Resource<DeleteAccountGroupResponse>>()
    fun deleteAccountGroupName(): LiveData<Resource<DeleteAccountGroupResponse>> {
        return _deleteAccountGroupName
    }

    fun deleteAccountGroupFromWebServices(groupid: String) {
        viewModelScope.launch {
            _deleteAccountGroupName.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.deleteAccountGroup(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), groupid),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.userid)
                )

                _deleteAccountGroupName.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _deleteAccountGroupName.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

    //updateAccount----------------------------------
    private val _updateAccountGroupName = MutableLiveData<Resource<UpdateAccountGroupNameResponse>>()
    fun updateAccountGroupName(): LiveData<Resource<UpdateAccountGroupNameResponse>> {
        return _updateAccountGroupName
    }

    fun updateAccountGroupNameToWebServices(name:String,groupid:String) {
        viewModelScope.launch {
            _updateAccountGroupName.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.updateAccountGroupName(
                        RequestBody.create("text/plain".toMediaTypeOrNull(), name),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), groupid),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.userId),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.token),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), LoginActivity.app_verision),
                        RequestBody.create("text/plain".toMediaTypeOrNull(), loggedInUser.userid)
                )

                _updateAccountGroupName.postValue(Resource.success(data = response))
            } catch (exception: Exception) {
                _updateAccountGroupName.postValue(
                        Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!$exception"
                        )
                )
            }
        }
    }

}