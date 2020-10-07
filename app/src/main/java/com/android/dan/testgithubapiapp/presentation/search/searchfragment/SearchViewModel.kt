package com.android.dan.testgithubapiapp.presentation.search.searchfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.domain.IGitRepository
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val repository: IGitRepository) : BaseViewModel() {

    var searchQuery = MutableLiveData<String>("")

    private var _searchRepositoriesLiveData = MutableLiveData<List<GitRepositoryEntity>>()
    val searchRepositoriesLiveData: LiveData<List<GitRepositoryEntity>> = _searchRepositoriesLiveData

    fun startSearch() {
        showProgressBar()
        scope.launch {
            val result = repository.searchRepositories(searchQuery.value!!)
            when (result) {
                is Result.SuccessResult<*> -> {
                    val list = result.result as List<GitRepositoryEntity>
                    _searchRepositoriesLiveData.postValue(list)
                }
                is Result.ExceptionResult -> Log.e("TAG", result.exception)
            }
            hideProgressBar()
        }
    }
}