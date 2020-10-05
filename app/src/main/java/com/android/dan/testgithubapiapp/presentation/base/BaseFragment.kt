package com.android.dan.testgithubapiapp.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.dan.testgithubapiapp.presentation.dialog.ProgressDialogFragment
import com.android.dan.testgithubapiapp.presentation.utils.ViewModelFactory
import com.android.dan.testgithubapiapp.presentation.utils.observer
import com.google.android.material.textfield.TextInputLayout
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : DaggerFragment(contentLayoutId) {

    @Inject
    lateinit var factory: ViewModelFactory

    protected val viewModel: VM by lazy {
            ViewModelProvider(this, factory).get(
                (javaClass.genericSuperclass as ParameterizedType)
                    .actualTypeArguments[0] as Class<VM>)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
    }

    fun showProgressBar() = ProgressDialogFragment.show(childFragmentManager)

    fun hideProgressBar() = ProgressDialogFragment.dismiss(childFragmentManager)

    protected fun showError(textInputLayout: TextInputLayout?, errorMessage: String?) {
        textInputLayout?.error = errorMessage
    }

    @CallSuper
    protected open fun subscribe() {
        viewModel.visibleProgressBarLiveData.observer(this){
            if (it) showProgressBar() else hideProgressBar()
        }
    }
}