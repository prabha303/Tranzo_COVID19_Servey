package com.covid91.tranzo.ui.tranzo.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants

object TransoSurveyFragmentLoader {

    fun loadFragment(activity: TranzoSurveillanceActivity, fragmentId: Int, data: Bundle?): Fragment? {

        var fragment: Fragment? = null
        var fragmentTag: String? = null

        when (fragmentId) {
            Constants.FIRST_SURVEY_FRAGMENT -> {
                fragmentTag = FirstSurveyFragment::class.java.simpleName
                fragment = FirstSurveyFragment.newInstance()
                fragment.setArguments(data)
            }

            Constants.FRAGMENT_PERSON_1 -> {
                fragmentTag = PersonOneFragment::class.java.simpleName
                fragment = PersonOneFragment.newInstance()
                fragment.setArguments(data)
            }
            Constants.FRAGMENT_PERSON_2 -> {
                fragmentTag = PersonTwoFragment::class.java.simpleName
                fragment = PersonTwoFragment.newInstance()
                fragment.setArguments(data)
            }

            Constants.FRAGMENT_GENERSL_INFO -> {
                fragmentTag = GeneralInfoFragment::class.java.simpleName
                fragment = GeneralInfoFragment.newInstance()
                fragment.setArguments(data)
            }

            else -> {
            }
        }

        if (fragment != null) {
            val transaction = activity.supportFragmentManager.beginTransaction().addToBackStack(null)
            transaction.replace(R.id.container, fragment, fragmentTag)
            transaction.commitAllowingStateLoss()
        }
        return fragment
    }

}