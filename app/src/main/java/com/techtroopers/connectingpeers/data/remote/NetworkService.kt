package com.techtroopers.connectingpeers.data.remote

import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    @POST("api/v1/enroll-user")
    suspend fun fetchEnrolledUsersList() : EnrolledUsers
}