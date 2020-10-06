package com.android.dan.testgithubapiapp.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

class Controller() {

    private val BASE_URL = "https://api.github.com/"
    private val sHttpClient = OkHttpClient.Builder()
    private val sBuilder = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun createService() : GitApi{
//        sHttpClient.addInterceptor(headerInterceptor)
        val retrofit = sBuilder
            .client(sHttpClient.build())
            .build()
        return retrofit.create(GitApi::class.java)
    }
}