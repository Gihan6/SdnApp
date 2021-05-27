package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModels.request.SessionTokenRequest


class ApiHelper (private val apiService: ApiService) {
    suspend fun getSessionToken(request: SessionTokenRequest) = apiService.getSessionToken(request)

}