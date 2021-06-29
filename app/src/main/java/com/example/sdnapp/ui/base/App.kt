package com.example.sdnapp.ui.base

import android.app.Application
import com.example.sdnapp.di.appModules
import com.example.sdnapp.di.loginViewModelModule
import com.example.sdnapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Unique initialization of Dependency Injection library to allow the use of application context
        startKoin {
            androidLogger()
            androidContext(this@App)

            // TODO Await fix for Koin and replace the explicit invocations
            //  of loadModules() and createRootScope() with a single call to modules()
            //  (https://github.com/InsertKoinIO/koin/issues/847)
            koin.loadModules(listOf(appModules, viewModelModule, loginViewModelModule))
            koin.createRootScope()

        }


    }

}