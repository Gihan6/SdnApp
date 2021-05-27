package com.example.sdnapp.ui.main.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.data.networkModels.response.SessionTokenResponse
import com.example.sdnapp.ui.main.repository.MainRepository
import com.example.sdnapp.util.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

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

}