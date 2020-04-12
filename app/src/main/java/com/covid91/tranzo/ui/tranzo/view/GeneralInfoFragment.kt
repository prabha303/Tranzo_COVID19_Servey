package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.tranzo.model.ServeyModel
import com.covid91.tranzo.ui.tranzo.viewmodel.PersonTwoViewModel
import com.lynkdriver.lynk.factory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_general_info.view.*
import javax.inject.Inject

class GeneralInfoFragment constructor(): BaseFragment() {

    @Inject
    lateinit var viewmodelfactory: ViewModelFactory
    lateinit var viewmodel: PersonTwoViewModel

    lateinit var rootView: View
    private lateinit var mContext: Context
    private lateinit var serveyModel: ServeyModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_general_info, container, false)
        return rootView
    }
    companion object {
        fun newInstance() = GeneralInfoFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        serveyModel = arguments?.getParcelable<ServeyModel>(Constants.SERVEYMODEL)!!

        rootView.area.setText(serveyModel.familyServeyModel?.ServeyArea)
        rootView.address.setText(serveyModel.familyServeyModel?.Address)
        rootView.first_member.setText( "${serveyModel.familyServeyModel?.FamilyHeadPersonName } + ${serveyModel.familyServeyModel?.NumberOfPeopleStayingCount}")

        rootView.person_1_name.setText("${serveyModel.personModelOne?.PersonName}, ${serveyModel.personModelOne?.Age}")
        rootView.gerder_1.setText("${serveyModel.personModelOne?.Gender}, ${serveyModel.personModelOne?.MobileNumber}")


        rootView.age_60_count.setText("${serveyModel.familyServeyModel?.AgedPeopleCount}")
        rootView.kids_below10_count.setText("${serveyModel.familyServeyModel?.KidsBelow10Count}")

        rootView.person_2_name.setText("${serveyModel.personModelTwo?.PersonName}, ${serveyModel.personModelTwo?.Age}")
        rootView.gerder_2.setText("${serveyModel.personModelTwo?.Gender}")



        rootView.verify_and_save.setOnClickListener {
            Toast.makeText(mContext," Saved Successfully ", Toast.LENGTH_LONG).show()
            (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_CLOSE, null)
        }
        rootView.member_gradient_2.setBackgroundResource(R.drawable.member_gradient_2)
        rootView.member_gradient_1.setBackgroundResource(R.drawable.member_gradient_1)
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}

