package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.di.scopes.FragmentScoped
import com.android.dan.testgithubapiapp.presentation.auth.login.LoginFragment
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindRepositoriesFragment(): RepositoriesFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment
}