package com.android.dan.testgithubapiapp.data.api

import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.data.entity.SearchResult
import com.android.dan.testgithubapiapp.data.entity.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitApi {

    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") username: String): Response<List<GitRepositoryEntity>>

    @GET("users/{user}")
    suspend fun checkUserExistence(@Path("user") username: String): Response<User>

    @GET("search/repositories")
    suspend fun searchListRepositories(@Query("q") query: String): Response<SearchResult>
}