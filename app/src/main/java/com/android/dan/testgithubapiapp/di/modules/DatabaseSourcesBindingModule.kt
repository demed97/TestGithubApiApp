package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.domain.RepoRepository
import com.android.dan.testgithubapiapp.domain.RepoRepositoryImp
import dagger.Binds
import dagger.Module

@Module
interface DatabaseSourcesBindingModule {

    @Binds
    fun bindShoppingListSource(repo: RepoRepositoryImp): RepoRepository
}