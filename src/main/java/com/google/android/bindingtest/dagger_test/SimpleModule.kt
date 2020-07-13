package com.google.android.bindingtest

import dagger.Module
import dagger.Provides

@Module
class SimpleModule {
    @Provides
    fun provideStringProvider(): StringProvider {
        return object: StringProvider { override fun getString() = "Test string from Kotlin" }
    }
}
