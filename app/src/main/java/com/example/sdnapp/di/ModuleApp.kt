package com.example.sdnapp.di


import com.example.sdnapp.data.api.ApiHelper
import com.example.sdnapp.data.api.RetrofitBuilder
import com.example.sdnapp.data.repository.MainRepository
import com.example.sdnapp.db.DataBase
import com.example.sdnapp.ui.dashboard.driver.DriverViewModel
import com.example.sdnapp.ui.dashboard.driverVehicle.DriverVehicleViewModel
import com.example.sdnapp.ui.dashboard.groups.GroupsViewModel
import com.example.sdnapp.ui.dashboard.liveTracking.LiveTrackViewModel
import com.example.sdnapp.ui.dashboard.setting.SettingViewModel
import com.example.sdnapp.ui.dashboard.vechicle.viewModel.VehicleViewModel
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
val vehicleViewModelModule = module {
    viewModel { VehicleViewModel(get()) }
}
val driverViewModelModule = module {
    viewModel { DriverViewModel(get()) }
}
val driverVehicleViewModelModule = module {
    viewModel { DriverVehicleViewModel(get()) }
}
val groupsViewModelModule = module {
    viewModel { GroupsViewModel(get()) }
}
val settingViewModelModule = module {
    viewModel { SettingViewModel(get()) }
}
val liveTrackViewModel = module {
    viewModel { LiveTrackViewModel(get()) }
}