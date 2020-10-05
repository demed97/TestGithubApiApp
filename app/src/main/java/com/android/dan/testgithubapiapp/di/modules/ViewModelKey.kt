package com.android.dan.testgithubapiapp.di.modules

import androidx.lifecycle.ViewModel
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel>)