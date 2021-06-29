package com.example.sdnapp.di


import com.example.sdnapp.data.api.ApiHelper
import com.example.sdnapp.data.api.RetrofitBuilder
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.db.DataBase
import com.example.sdnapp.ui.login.LoginViewModel
import com.example.sdnapp.ui.main.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    single { DataBase.getInstance(get()) }
    factory { RetrofitBuilder.apiService }
    factory { ApiHelper(get()) }
    single { MainRepository(get()) }

}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
val loginViewModelModule = module {
    viewModel { LoginViewModel(get()) }
}