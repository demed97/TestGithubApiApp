package com.android.dan.testgithubapiapp.data.entity

import com.google.gson.annotations.SerializedName

data class GitRepositoryEntity(
    var id: Int,
    var name: String,
    @SerializedName("private")
    var isPrivate: String,
    @SerializedName("html_url")
    var link: String,
    var description: String,
    var owner: User
) {
}