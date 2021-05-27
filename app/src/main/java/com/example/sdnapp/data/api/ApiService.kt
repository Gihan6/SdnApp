package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.data.networkModels.response.SessionTokenResponse
import retrofit2.http.POST



interface ApiService {

    @POST("user.getsessiontoken")
    suspend fun getSessionToken(request: SessionTokenRequest): SessionTokenResponse


}