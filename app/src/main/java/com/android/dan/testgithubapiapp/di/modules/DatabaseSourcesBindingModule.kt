package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.domain.IGitRepository
import com.android.dan.testgithubapiapp.domain.GitRepository
import dagger.Binds
import dagger.Module

@Module
interface DatabaseSourcesBindingModule {

    @Binds
    fun bindShoppingListSource(repo: GitRepository): IGitRepository
}