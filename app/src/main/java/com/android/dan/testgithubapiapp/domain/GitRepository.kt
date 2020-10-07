package com.android.dan.testgithubapiapp.domain

import com.android.dan.testgithubapiapp.data.api.GitApi
import com.android.dan.testgithubapiapp.data.entity.Credentials
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.utils.Result
import javax.inject.Inject

class GitRepository @Inject constructor(val gitApi: GitApi) : IGitRepository {

    override suspend fun listRepositories(user: User): Result {
        val response = gitApi.listRepositories(user.username)
        return if (response.isSuccessful) {
            Result.SuccessResult(response.body()!!)
        } else
            Result.ExceptionResult(
                response.errorBody()?.string()
                    ?: "Something goes wrong in GitRepository listRepositories()"
            )
    }

    override suspend fun checkUserExistence(credentials: Credentials): Result {
        val response = gitApi.checkUserExistence(credentials.username)
        return if (response.isSuccessful) {
            Result.SuccessResult(response.body()!!)
        } else
            Result.ExceptionResult(
                response.errorBody()?.string()
                    ?: "Something goes wrong in GitRepository checkUserExistence()"
            )
    }

    override suspend fun searchRepositories(searchQuery: String): Result {
        val response = gitApi.searchListRepositories(searchQuery)
        return if (response.isSuccessful) {
            Result.SuccessResult(response.body()!!.items)
        } else
            Result.ExceptionResult(
                response.errorBody()?.string()
                    ?: "Something goes wrong in GitRepository searchRepositories()"
            )
    }
}