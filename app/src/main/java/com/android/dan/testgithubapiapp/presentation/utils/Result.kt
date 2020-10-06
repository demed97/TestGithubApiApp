package com.android.dan.testgithubapiapp.presentation.utils

sealed class Result {
    data class SuccessResult<out T: Any>(val result: T) : Result()
    data class ExceptionResult(val exception: String) : Result()
}