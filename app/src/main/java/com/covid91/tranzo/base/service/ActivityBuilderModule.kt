package com.covid91.tranzo.base.service

import com.covid91.tranzo.ui.di.FuelApiModule
import com.covid91.tranzo.ui.di.FuelStationScope
import com.covid91.tranzo.ui.di.FuelViewModelModule
import com.covid91.tranzo.ui.view.FuelStationsListActivty
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @FuelStationScope
    @ContributesAndroidInjector(modules = [FuelViewModelModule::class, FuelApiModule::class])
    abstract fun contributeFuelStationsListActivty(): FuelStationsListActivty



}