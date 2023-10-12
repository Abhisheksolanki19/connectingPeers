package com.techtroopers.connectingpeers.data.repository

import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import com.techtroopers.connectingpeers.data.remote.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MyCourseRepository @Inject constructor(
    private val networkService: NetworkService,
) {

    fun fetchEnrolledUsersList(): Flow<EnrolledUsers> {
        return flow {
            emit(networkService.fetchEnrolledUsersList())
        }
    }

}