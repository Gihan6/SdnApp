package com.example.sdnapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.data.networkModels.response.SessionTokenResponse
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.db.Repo
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class LoginViewModel(private val mainRepository: MainRepository) : ViewModel() {


    private val sessionToken = MutableLiveData<Resource<SessionTokenResponse>>()
    fun getSessionToken(): LiveData<Resource<SessionTokenResponse>> {
        return sessionToken
    }

    fun getSessionTokenFromWebServices(request: SessionTokenRequest) {
        viewModelScope.launch {
            sessionToken.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getSessionTokenRepo(request)
                sessionToken.postValue(Resource.success(data = response))
                if (response.data!=null){
                    mainRepository.saveUser(Repo(1,response.data.userid,response.data.token))
                }
            } catch (exception: Exception) {

                sessionToken.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!$exception"
                    )
                )
            }
        }
    }

    private val loggedInUser = MutableLiveData<Resource<Repo>>()
    fun getLoggedInUser(): LiveData<Resource<Repo>> {
        return loggedInUser
    }

    fun getLoggedInUserFromLocal() {
        viewModelScope.launch {
            loggedInUser.postValue(Resource.loading(data = null))
            try {
                val response = mainRepository.getUser()
                loggedInUser.postValue(Resource.success(data = response) as Resource<Repo>?)

            } catch (exception: Exception) {
                loggedInUser.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!$exception"
                    )
                )
            }
        }
    }

}