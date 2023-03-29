package com.yuriykyus.walry.app

import android.app.Application
import com.yuriykyus.walry.di.AppComponent
import com.yuriykyus.walry.di.AppModule
import com.yuriykyus.walry.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        // because create a context
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}