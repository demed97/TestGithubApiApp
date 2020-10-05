package com.android.dan.testgithubapiapp.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out BaseViewModel>, @JvmSuppressWildcards Provider<BaseViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}