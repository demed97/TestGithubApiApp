package com.android.dan.testgithubapiapp.presentation.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.dan.testgithubapiapp.data.entity.Credentials
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.SingleLiveEvent
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val _onAuthorizationSuccessfulEvent = SingleLiveEvent<Unit>()
    val onAuthorizationSuccessfulEvent: LiveData<Unit> = _onAuthorizationSuccessfulEvent

    var login = MutableLiveData<Credentials>(Credentials("", ""))

    fun loginClick(){

    }
}