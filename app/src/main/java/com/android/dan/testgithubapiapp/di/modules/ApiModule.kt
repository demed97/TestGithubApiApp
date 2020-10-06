package com.android.dan.testgithubapiapp.di.modules

import com.android.dan.testgithubapiapp.data.api.Controller
import com.android.dan.testgithubapiapp.data.api.GitApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun getController(): Controller {
        return Controller()
    }

    @Singleton
    @Provides
    fun getApi(controller: Controller): GitApi {
        return controller.createService()
    }
}