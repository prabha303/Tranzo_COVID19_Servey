package com.covid91.tranzo.ui.tranzo.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants

object TransoSurveyFragmentLoader {

    fun loadFragment(activity: TranzoSurveillanceActivity, viewColor: View, fragmentId: Int, data: Bundle?): Fragment? {

        var fragment: Fragment? = null
        var fragmentTag: String? = null

        when (fragmentId) {

            Constants.ALL_TRIPS_FRAGMENT -> {
                fragmentTag = FirstSurveyFragment::class.java.simpleName
                fragment = FirstSurveyFragment.newInstance(activity)
                fragment.setArguments(data)
                viewColor.visibility = View.GONE
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