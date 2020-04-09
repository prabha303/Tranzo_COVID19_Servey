package com.covid91.tranzo.base.service
import com.covid91.tranzo.ui.tranzo.di.TranzoApiModule
import com.covid91.tranzo.ui.tranzo.di.TranzoServeyScope
import com.covid91.tranzo.ui.tranzo.di.TranzoViewModelModule
import com.covid91.tranzo.ui.tranzo.view.TranzoSurveillanceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @TranzoServeyScope
    @ContributesAndroidInjector(modules = [TranzoViewModelModule::class, FragmentBuilderModule::class, TranzoApiModule::class])
    abstract fun contributeTranzoSurveillanceActivity(): TranzoSurveillanceActivity



}