package com.covid91.tranzo.ui.tranzo.di

import androidx.lifecycle.ViewModel
import com.covid91.tranzo.base.ViewModelKey
import com.covid91.tranzo.ui.tranzo.viewmodel.PersonTwoViewModel
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TranzoViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TranzoSurveyViewModel::class)
    protected abstract fun tranzoSurveyViewModel(tranzoSurveyViewModel: TranzoSurveyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonTwoViewModel::class)
    protected abstract fun tranzopersonTwoViewModel(personTwoViewModel: PersonTwoViewModel): ViewModel




}