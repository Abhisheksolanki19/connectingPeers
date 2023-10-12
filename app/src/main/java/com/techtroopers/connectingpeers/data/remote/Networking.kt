package com.techtroopers.connectingpeers.data.remote

import com.techtroopers.connectingpeers.utils.network.FakeAPIInterceptor
import com.squareup.moshi.Moshi
import com.squareup.picasso.BuildConfig
import com.techtroopers.connectingpeers.ConnectingPeers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {

    fun create(
        baseUrl: String,
    ): NetworkService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            OkHttpClient.Builder()
                .apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(FakeAPIInterceptor(ConnectingPeers.INSTANCE))
                    }
                }
                .build()
        )
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
        .create(NetworkService::class.java)
}