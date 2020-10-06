package com.android.dan.testgithubapiapp.presentation.auth.login

import android.content.Intent
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import com.android.dan.testgithubapiapp.presentation.main.MainActivity
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesFragment
import com.android.dan.testgithubapiapp.presentation.main.list.RepositoriesViewModel
import com.android.dan.testgithubapiapp.presentation.utils.observer

class LoginFragment :
    BaseFragment<LoginViewModel>(R.layout.fragment_login) {

    override fun subscribe() {
        super.subscribe()
        viewModel.onAuthorizationSuccessfulEvent.observer(this) {
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(context, MainActivity::class.java))
        requireActivity().finish()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}