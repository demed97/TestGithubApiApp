package com.android.dan.testgithubapiapp.presentation.main.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.domain.IGitRepository
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.Result.*
import com.android.dan.testgithubapiapp.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoriesViewModel @Inject constructor(val repository: IGitRepository) : BaseViewModel() {

    private var _repositoriesLiveData = MutableLiveData<List<GitRepositoryEntity>>()
    val repositoriesLiveData: LiveData<List<GitRepositoryEntity>> = _repositoriesLiveData

    private var _fabClickEvent = SingleLiveEvent<Unit>()
    val fabClickEvent: LiveData<Unit> = _fabClickEvent

    fun fabClick() {
        _fabClickEvent.value = Unit
    }

    fun loadRepositories(user: User) {
        showProgressBar()
        scope.launch {
            val result = repository.listRepositories(user)
            when (result) {
                is SuccessResult<*> -> {
                    val list = result.result as List<GitRepositoryEntity>
                    _repositoriesLiveData.postValue(list)
                }
                is ExceptionResult -> Log.e("TAG", result.exception)
            }
            delay(2000)
            hideProgressBar()
        }
    }
}