package com.android.dan.testgithubapiapp.presentation.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.dan.testgithubapiapp.presentation.utils.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : DaggerAppCompatActivity(contentLayoutId) {

    @Inject
    lateinit var factory: ViewModelFactory

    protected val viewModel: VM by lazy {
        ViewModelProvider(this, factory).get(
            (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<VM>)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribe()
    }

    @CallSuper
    protected open fun subscribe() {
    }
}