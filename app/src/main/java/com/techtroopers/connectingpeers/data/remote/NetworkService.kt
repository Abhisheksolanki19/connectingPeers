package com.techtroopers.connectingpeers.data.remote

import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import retrofit2.http.GET

interface NetworkService {

    @GET("test/fetch/book/list")
    suspend fun fetchEnrolledUsersList() : List<EnrolledUsers>
}