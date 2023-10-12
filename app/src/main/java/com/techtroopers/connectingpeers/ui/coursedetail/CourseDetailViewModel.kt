package com.techtroopers.connectingpeers.ui.coursedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import com.techtroopers.connectingpeers.data.repository.MyCourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val myCourseRepository: MyCourseRepository
) : ViewModel() {

    init {
        fetchEnrolledUsersList()
    }

    companion object {
        const val TAG = "MyCourseViewModel"
    }

    private val _enrolledUsersList = MutableLiveData<EnrolledUsers>()
    val enrolledUsersList: LiveData<EnrolledUsers> = _enrolledUsersList

    private fun fetchEnrolledUsersList() {
        viewModelScope.launch {
            myCourseRepository.fetchEnrolledUsersList()
                .catch { error ->
                    Log.e(TAG, error.toString())
                }
                .collect {
                    _enrolledUsersList.postValue(it)
                }
        }
    }
}