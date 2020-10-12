package com.android.dan.testgithubapiapp.presentation.search.searchfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.domain.IGitRepository
import com.android.dan.testgithubapiapp.presentation.adapter.RepositoryDataSourceFactory
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val repository: IGitRepository) : BaseViewModel() {

    var searchQuery = MutableLiveData<String>("")

    private val repoDataSource = RepositoryDataSourceFactory(repository, scope = scope)
    val repos = LivePagedListBuilder(repoDataSource, pagedListConfig()).build()

    private var _searchRepositoriesLiveData = MutableLiveData<List<GitRepositoryEntity>>()
    val searchRepositoriesLiveData: LiveData<List<GitRepositoryEntity>> =
        _searchRepositoriesLiveData

    fun fetchReposByName() {
        val search = searchQuery.value?.trim()
        if (repoDataSource.getQuery() == search) return
        repoDataSource.updateQuery(search!!, "name")
    }

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

    private fun pagedListConfig() = PagedList.Config.Builder()
        .setInitialLoadSizeHint(20)
        .setEnablePlaceholders(false)
        .setPageSize(5 * 2)
        .build()
}