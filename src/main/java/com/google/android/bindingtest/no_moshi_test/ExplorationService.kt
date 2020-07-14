package com.google.android.bindingtest.no_moshi_test

import com.google.android.bindingtest.no_moshi_test.GaeExplorationContainer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/** Service that provides access to exploration endpoints. */
interface ExplorationService {

    @GET("explorehandler/init/umPkwp0L1M0-")
    fun getExplorationById(): Call<GaeExplorationContainer>
}