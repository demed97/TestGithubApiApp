package com.android.dan.testgithubapiapp.domain

import com.android.dan.testgithubapiapp.data.api.GitApi
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.utils.Result

interface RepoRepository {

    suspend fun listRepositories(user: User) : Result

}