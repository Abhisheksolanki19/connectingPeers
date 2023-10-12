package com.techtroopers.connectingpeers.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.techtroopers.connectingpeers.data.remote.NetworkService
import com.techtroopers.connectingpeers.data.remote.Networking
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        return Networking.create(
            "http://172.18.8.120:3000/",
        )
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences("connectingPeers-prefs", Context.MODE_PRIVATE)
}