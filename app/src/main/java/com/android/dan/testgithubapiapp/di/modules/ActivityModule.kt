package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.di.scopes.ActivityScoped
import com.android.dan.testgithubapiapp.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}