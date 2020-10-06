package com.android.dan.testgithubapiapp.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    var id: Int,
    @SerializedName("login")
    var username: String,
//    @SerializedName("avatar_url")
//    var avatarUrl: String,
    @SerializedName("html_url")
    var link: String,
) {
}