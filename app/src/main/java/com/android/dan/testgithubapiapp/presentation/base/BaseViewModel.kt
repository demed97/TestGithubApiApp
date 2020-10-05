package com.android.dan.testgithubapiapp.presentation.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    private val _visibleProgressBarLiveData = MutableLiveData<Boolean>()
    val visibleProgressBarLiveData: LiveData<Boolean> = _visibleProgressBarLiveData

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(TAG, "CoroutineExceptionHandler got", exception)
    }

    val scope = viewModelScope + handler + Dispatchers.Default

    companion object{
        private val TAG = this::class.java.name
    }

    fun showProgressBar() = _visibleProgressBarLiveData.postValue(true)

    fun hideProgressBar() = _visibleProgressBarLiveData.postValue(false)
}