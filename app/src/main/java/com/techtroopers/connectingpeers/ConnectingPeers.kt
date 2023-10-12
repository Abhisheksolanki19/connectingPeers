package com.techtroopers.connectingpeers

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ConnectingPeers : Application() {

    companion object {
        lateinit var INSTANCE: ConnectingPeers
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}