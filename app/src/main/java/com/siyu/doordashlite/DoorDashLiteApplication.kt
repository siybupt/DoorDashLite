package com.siyu.doordashlite

import com.siyu.doordashlite.dagger.AppComponent
import android.app.Application
import com.siyu.doordashlite.dagger.AppModule
import com.siyu.doordashlite.dagger.DaggerAppComponent

class DoorDashLiteApplication : Application() {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getDagger(): AppComponent {
        return appComponent
    }
}