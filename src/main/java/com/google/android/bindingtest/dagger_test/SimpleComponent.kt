package com.google.android.bindingtest

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SimpleModule::class])
interface SimpleComponent {
    @Component.Builder
    interface Builder {
        fun build(): SimpleComponent
    }

    fun getStringProvider(): StringProvider
}
