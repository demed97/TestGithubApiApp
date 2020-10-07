package com.android.dan.testgithubapiapp.presentation.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.dan.testgithubapiapp.data.entity.Credentials
import com.android.dan.testgithubapiapp.data.entity.User
import com.android.dan.testgithubapiapp.domain.IGitRepository
import com.android.dan.testgithubapiapp.presentation.base.BaseViewModel
import com.android.dan.testgithubapiapp.presentation.utils.Result
import com.android.dan.testgithubapiapp.presentation.utils.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(val repository: IGitRepository) : BaseViewModel() {

    private var _onAuthorizationSuccessfulEvent = SingleLiveEvent<User>()
    val onAuthorizationSuccessfulEvent: LiveData<User> = _onAuthorizationSuccessfulEvent

    private var _showToastEvent = SingleLiveEvent<Unit>()
    val showToastEvent: LiveData<Unit> = _showToastEvent

    var login = MutableLiveData<Credentials>(Credentials(""))

    fun loginClick() {
        showProgressBar()
        scope.launch {
            val result = repository.checkUserExistence(login.value!!)
            when (result) {
                is Result.SuccessResult<*> -> {
                    val user = result.result as User
                    _onAuthorizationSuccessfulEvent.postValue(user)

                }
                is Result.ExceptionResult -> _showToastEvent.postValue(Unit)
            }
            delay(500)
            hideProgressBar()
        }
    }
}