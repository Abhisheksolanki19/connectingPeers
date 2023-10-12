package com.techtroopers.connectingpeers.comm

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Section(
    @Json(name = "name")
    val name: String,

    @Json(name = "title")
    val title: String
) : Parcelable
