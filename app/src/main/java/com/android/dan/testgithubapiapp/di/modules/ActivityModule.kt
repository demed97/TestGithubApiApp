package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.di.scopes.ActivityScoped
import com.android.dan.testgithubapiapp.presentation.auth.AuthActivity
import com.android.dan.testgithubapiapp.presentation.main.MainActivity
import com.android.dan.testgithubapiapp.presentation.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindAuthActivity(): AuthActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindSearchActivity(): SearchActivity
}