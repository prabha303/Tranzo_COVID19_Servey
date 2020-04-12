package com.covid91.tranzo.base.service

import com.covid91.tranzo.ui.tranzo.view.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFirstSurveyFragment(): FirstSurveyFragment

    @ContributesAndroidInjector
    abstract fun contributePersonOneFragment(): PersonOneFragment

    @ContributesAndroidInjector
    abstract fun contributePersonTwoFragment(): PersonTwoFragment

    @ContributesAndroidInjector
    abstract fun contributeGeneralInfoFragment(): GeneralInfoFragment

}