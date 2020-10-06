package com.android.dan.testgithubapiapp.data.api

import com.android.dan.testgithubapiapp.data.entity.GitRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {

    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") username: String): Response<List<GitRepository>>
}