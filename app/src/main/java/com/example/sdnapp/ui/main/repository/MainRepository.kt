package com.example.sdnapp.ui.main.repository

import android.util.Log
import com.example.sdnapp.data.api.ApiHelper
import com.example.sdnapp.data.networkModels.request.SessionTokenRequest
import com.example.sdnapp.db.DataBase
import com.example.sdnapp.db.Repo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject


class MainRepository(private val apiHelper: ApiHelper) : KoinComponent {

    private val dataBase by inject<DataBase>()

    suspend fun getSessionTokenRepo(request: SessionTokenRequest) = apiHelper.getSessionToken(request)

//    suspend fun saveRepos(repos: List<Repo>) {
//        try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                for (repo in repos) {
//                    dataBase.repoDao().insert(repo)
//                }
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//        }
//    }

//    suspend fun clearRepo() {
//        try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                dataBase.repoDao().clear()
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//
//        }
//
//
//    }

//    suspend fun search(keyWord:String): List<Repo> {
//       return try {
//            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
//                dataBase.repoDao().filter(keyWord)
//            }
//        } catch (e: Exception) {
//            Log.e("dataBase", e.toString())
//           return emptyList<Repo>()
//
//        }
//
//
//    }
}