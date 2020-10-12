package com.android.dan.testgithubapiapp.presentation.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.android.dan.testgithubapiapp.data.entity.GitRepositoryEntity
import com.android.dan.testgithubapiapp.domain.IGitRepository
import kotlinx.coroutines.CoroutineScope

class RepositoryDataSourceFactory(private val repository: IGitRepository,
                                  private var query: String = "",
                                  private var sort: String = "",
                                  private val scope: CoroutineScope
): DataSource.Factory<Int, GitRepositoryEntity>() {

    val source = MutableLiveData<RepositoryDataSource>()

    override fun create(): DataSource<Int, GitRepositoryEntity> {
        val source = RepositoryDataSource(repository, query, sort, scope)
        this.source.postValue(source)
        return source
    }

    fun getQuery() = query

    fun getSource() = source.value

    fun updateQuery(query: String, sort: String){
        this.query = query
        this.sort = sort
        getSource()?.refresh()
    }
}