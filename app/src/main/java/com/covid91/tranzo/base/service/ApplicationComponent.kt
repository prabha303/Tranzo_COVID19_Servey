package com.covid91.tranzo.base.service

import android.app.Application
import com.covid91.tranzo.base.TranzoApplication
import com.lynkdriver.lynk.factory.FactoryModule
import com.lynkdriver.lynk.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilderModule::class, FactoryModule::class])
interface ApplicationComponent: AndroidInjector<TranzoApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}