package com.android.dan.testgithubapiapp.presentation.main.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.dan.testgithubapiapp.data.entity.GitRepository
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.domain.RepoRepository
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.Result.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoriesViewModel @Inject constructor(val repository: RepoRepository) : BaseViewModel() {

    private var _repositoriesLiveData = MutableLiveData<List<GitRepository>>()
    val repositoriesLiveData: LiveData<List<GitRepository>> = _repositoriesLiveData

    fun loadRepositories() {
        scope.launch {
            val result = repository.listRepositories(User(1, "demed97", ""))
            when (result) {
                is SuccessResult<*> -> {
                    val list = result.result as List<GitRepository>
                    _repositoriesLiveData.postValue(list)
                }
                is ExceptionResult -> Log.e("TAG", result.exception)
            }
        }
    }
}