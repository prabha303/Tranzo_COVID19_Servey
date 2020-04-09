package com.covid91.tranzo.ui.di

import androidx.lifecycle.ViewModel
import com.covid91.tranzo.base.ViewModelKey
import com.covid91.tranzo.ui.viewmodel.FuelStationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FuelViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FuelStationViewModel::class)
    protected abstract fun abortViewModel(abortViewModelModule: FuelStationViewModel): ViewModel
}