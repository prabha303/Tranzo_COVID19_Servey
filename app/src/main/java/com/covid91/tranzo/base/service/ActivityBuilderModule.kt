package com.covid91.tranzo.base.service

import com.covid91.tranzo.ui.di.FuelApiModule
import com.covid91.tranzo.ui.di.FuelStationScope
import com.covid91.tranzo.ui.di.FuelViewModelModule
import com.covid91.tranzo.ui.tranzo.di.TranzoApiModule
import com.covid91.tranzo.ui.tranzo.di.TranzoServeyScope
import com.covid91.tranzo.ui.tranzo.di.TranzoViewModelModule
import com.covid91.tranzo.ui.tranzo.view.TranzoSurveillanceActivity
import com.covid91.tranzo.ui.view.FuelStationsListActivty
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @FuelStationScope
    @ContributesAndroidInjector(modules = [FuelViewModelModule::class, FuelApiModule::class])
    abstract fun contributeFuelStationsListActivty(): FuelStationsListActivty

    @TranzoServeyScope
    @ContributesAndroidInjector(modules = [TranzoViewModelModule::class, TranzoApiModule::class])
    abstract fun contributeTranzoSurveillanceActivity(): TranzoSurveillanceActivity





}