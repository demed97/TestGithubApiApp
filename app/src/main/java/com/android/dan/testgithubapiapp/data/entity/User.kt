package com.android.dan.testgithubapiapp.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: Int,
    @SerializedName("login")
    var username: String,
//    @SerializedName("avatar_url")
//    var avatarUrl: String,
    @SerializedName("html_url")
    var link: String,
) : Parcelable {
}