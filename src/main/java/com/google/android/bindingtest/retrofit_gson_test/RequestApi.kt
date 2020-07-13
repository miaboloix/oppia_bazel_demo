package com.google.android.bindingtest.retrofit_gson_test

import com.google.android.bindingtest.retrofit_gson_test.ExchangeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RequestApi {

    @GET("latest")
    fun getAllPosts(): Call<ExchangeResponse>

}