package com.techtroopers.connectingpeers.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Used for the current logged in user
 */
@Parcelize
data class EnrolledUsers(
    val userName: String,

    val userPassword: String,

    val country: String
) : Parcelable