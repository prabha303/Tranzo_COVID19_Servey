package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.covid91.tranzo.R
import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.tranzo.model.FamilyServeyModel
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import com.lynkdriver.lynk.factory.ViewModelFactory
import javax.inject.Inject


class FinalFragment : BaseFragment() {

    lateinit var rootView: View
    private lateinit var mContext: Context
    lateinit var familyServeyModel: FamilyServeyModel
    @Inject
    lateinit var viewmodelfactory: ViewModelFactory
    lateinit var viewmodel : TranzoSurveyViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_general_info, container, false)
        return rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(TranzoSurveyViewModel::class.java)


        observeViewModel()
    }

    fun observeViewModel() {

        familyServeyModel = arguments?.getParcelable<FamilyServeyModel>("family_servey_model")!!

        Log.d("familyServeyModel",familyServeyModel.ServeyArea)

    }


    companion object {
        fun newInstance() = FinalFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}

