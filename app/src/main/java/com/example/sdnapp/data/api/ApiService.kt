package com.example.sdnapp.data.api

import com.example.sdnapp.data.networkModel.response.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("repos")
    suspend fun getRepo(@Query("page") page:Int,@Query("per_page") per_page:Int): List<RepoResponse>
}