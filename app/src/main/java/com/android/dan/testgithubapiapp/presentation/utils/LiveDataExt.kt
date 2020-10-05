package com.android.dan.testgithubapiapp.presentation.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observer(owner: LifecycleOwner, observer: (T) -> Unit) =
    observe(owner, Observer { observer(it) })