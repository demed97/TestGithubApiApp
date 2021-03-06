package com.android.dan.testgithubapiapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.android.dan.testgithubapiapp.presentation.auth.AuthViewModel
import com.android.dan.testgithubapiapp.presentation.auth.login.LoginViewModel
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.main.MainViewModel
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesViewModel
import com.android.dan.testgithubapiapp.presentation.search.SearchActivityViewModel
import com.android.dan.testgithubapiapp.presentation.search.searchfragment.SearchViewModel
import com.android.dan.testgithubapiapp.presentation.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesViewModel::class)
    abstract fun bindRepositoriesViewModel(viewModel: RepositoriesViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchActivityViewModel::class)
    abstract fun bindSearchActivityViewModel(viewModel: SearchActivityViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): BaseViewModel
}