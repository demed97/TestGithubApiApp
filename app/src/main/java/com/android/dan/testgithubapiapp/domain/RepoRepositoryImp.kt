package com.android.dan.testgithubapiapp.domain

import com.android.dan.testgithubapiapp.data.api.GitApi
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.presentation.utils.Result
import javax.inject.Inject

class RepoRepositoryImp @Inject constructor (val gitApi: GitApi) : RepoRepository {

    override suspend fun listRepositories(user: User): Result {
        val response = gitApi.listRepositories(user.username)
        return if (response.isSuccessful) {
            Result.SuccessResult(response.body()!!)
        } else
            Result.ExceptionResult(
                response.errorBody()?.string() ?: "Something goes wrong in RepoRepositoryImp"
            )
    }
}