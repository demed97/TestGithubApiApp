package com.android.dan.testgithubapiapp.domain

import com.android.dan.testgithubapiapp.data.entity.Credentials
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.utils.Result

interface IGitRepository {

    suspend fun listRepositories(user: User) : Result

    suspend fun checkUserExistence(credentials: Credentials) : Result

    suspend fun searchRepositories(searchQuery: String) : Result

}