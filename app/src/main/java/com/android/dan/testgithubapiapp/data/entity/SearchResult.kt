package com.android.dan.testgithubapiapp.data.entity

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("items")
    val items: List<GitRepositoryEntity>
) {}