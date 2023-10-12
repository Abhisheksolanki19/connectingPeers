package com.techtroopers.connectingpeers.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EnrolledUsers(
    val userId: String,
    val userName: String
) : Parcelable