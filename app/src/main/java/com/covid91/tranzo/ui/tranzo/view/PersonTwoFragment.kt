package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_person_one.view.*

class PersonTwoFragment constructor() : BaseFragment() {

    lateinit var rootView: View
    private lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_person_two, container, false)

        rootView.next.setOnClickListener {
            (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_GENERSL_INFO, null)
        }

        rootView.previous.setOnClickListener {
            (mContext as TranzoSurveillanceActivity).onBackPressed()
        }

        return rootView
    }



    companion object {
        fun newInstance() = PersonTwoFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}

