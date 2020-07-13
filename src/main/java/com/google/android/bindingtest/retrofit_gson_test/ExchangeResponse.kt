package com.google.android.bindingtest.retrofit_gson_test

import com.google.android.bindingtest.retrofit_gson_test.Rates

data class ExchangeResponse(
        val rates: Rates? = null,
        val base: String
)