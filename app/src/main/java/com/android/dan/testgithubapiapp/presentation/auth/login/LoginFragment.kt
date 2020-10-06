package com.android.dan.testgithubapiapp.presentation.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.dan.testgithubapiapp.R
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.databinding.FragmentLoginBinding
import com.android.dan.testgithubapiapp.presentation.base.BaseFragment
import com.android.dan.testgithubapiapp.presentation.main.MainActivity
import com.android.dan.testgithubapiapp.presentation.utils.observer

class LoginFragment :
    BaseFragment<LoginViewModel>(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.setContentView<FragmentLoginBinding>(
            requireActivity(),
            R.layout.fragment_login
        )
        binding.loginViewModel = viewModel
    }

    override fun subscribe() {
        super.subscribe()
        viewModel.onAuthorizationSuccessfulEvent.observer(this) {
            startMainActivity(it)
        }
        viewModel.showToastEvent.observer(this) {
            Toast.makeText(context, getString(R.string.user_not_found), Toast.LENGTH_LONG).show()
        }
    }

    private fun startMainActivity(user: User) {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
        requireActivity().finish()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}