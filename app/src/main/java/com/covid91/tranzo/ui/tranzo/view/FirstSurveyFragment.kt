package com.covid91.tranzo.ui.tranzo.view

import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.di.IFragmentLoader

class FirstSurveyFragment constructor() : BaseFragment() {

    private var fragmentLoader: IFragmentLoader? = null

    constructor(fragmentLoader: IFragmentLoader?) : this() {
        this.fragmentLoader = fragmentLoader
    }
    companion object {
        fun newInstance(fragmentLoader: IFragmentLoader?) = FirstSurveyFragment(fragmentLoader)
    }



}

