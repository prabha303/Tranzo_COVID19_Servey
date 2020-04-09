package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GestureDetectorCompat
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_first_servey.*
import kotlinx.android.synthetic.main.fragment_first_servey.view.*

class FirstSurveyFragment constructor() : BaseFragment() {

    lateinit var rootView: View
    private lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_first_servey, container, false)

        rootView.save_and_continue.setOnClickListener {
            (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_PERSON_1, null)
        }

        return rootView
    }



    companion object {
        fun newInstance() = FirstSurveyFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}
