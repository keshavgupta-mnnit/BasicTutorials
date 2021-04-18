package com.keshav.basictutorials.lifecycle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(
    var msg: String
) : Parcelable