package com.covid91.tranzo.ui.di

import android.os.Bundle

interface IFragmentLoader {
    fun loadFragment(fragmentId: Int, data: Bundle?)
}