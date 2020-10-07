package com.android.dan.testgithubapiapp.presentation.auth

import android.os.Bundle
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.presentation.auth.login.LoginFragment
import com.android.dan.testgithubapiapp.presentation.base.BaseActivity

class AuthActivity : BaseActivity<AuthViewModel>(R.layout.activity_auth) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showLoginFragment()
    }

    private fun showLoginFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.authFragmentContainer, LoginFragment.newInstance())
            .commit()
        supportActionBar?.title = getString(R.string.login)
    }
}