package com.android.dan.testgithubapiapp.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun getApplication(application: Application): Context = application
}