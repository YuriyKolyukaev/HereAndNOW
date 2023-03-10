package com.yuriykyus.walry.core

import android.app.Application
import com.yuriykyus.walry.data.network.NetworkManager

class App : Application() {

    companion object {
        lateinit var networkManager: NetworkManager
    }

    override fun onCreate() {
        super.onCreate()
        networkManager = NetworkManager()
    }
}