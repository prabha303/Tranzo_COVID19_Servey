package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.tranzo.model.FamilyServeyModel
import com.covid91.tranzo.ui.tranzo.model.PersonModel
import com.covid91.tranzo.ui.tranzo.model.ServeyModel
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import com.lynkdriver.lynk.factory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_person_one.view.*
import javax.inject.Inject


class PersonOneFragment : BaseFragment() {

    lateinit var rootView: View
    private lateinit var mContext: Context
    lateinit var serveyModel: ServeyModel
    @Inject
    lateinit var viewmodelfactory: ViewModelFactory
    lateinit var viewmodel : TranzoSurveyViewModel

    var travalHistory = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_person_one, container, false)
        return rootView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(TranzoSurveyViewModel::class.java)

        rootView.next.setOnClickListener {
            viewmodel.covidSymptomsPersonOne.Cold =rootView.cold.isChecked
            viewmodel.covidSymptomsPersonOne.Cough =rootView.cough.isChecked
            viewmodel.covidSymptomsPersonOne.Fever =rootView.fever.isChecked
            viewmodel.covidSymptomsPersonOne.Tiredness =rootView.tiredness.isChecked

            viewmodel.otherHealthIssuesPersonOne.BloodPressure = rootView.blood_pressure.isChecked
            viewmodel.otherHealthIssuesPersonOne.Diabetes = rootView.diabetes.isChecked
            viewmodel.otherHealthIssuesPersonOne.Respiratory = rootView.respiratory.isChecked

            val genid: Int = rootView.gender_radio.getCheckedRadioButtonId()
            val radioButton = rootView.findViewById(genid) as RadioButton
            val gender = radioButton.text.toString()


            viewmodel.validatePersonOne(
                rootView.person_1_name.text.toString(),
                gender,
                rootView.age.text.toString(),
                rootView.mobile_number.text.toString(),
                travalHistory,
                rootView.traval_location.text.toString(),
                rootView.treatments_any.text.toString(),
                rootView.other_specific_illness.text.toString()
                )
        }
        rootView.previous.setOnClickListener {
            (mContext as TranzoSurveillanceActivity).onBackPressed()
        }
        rootView.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.yes) {
                travalHistory = true
                rootView.traval_location.visibility = View.VISIBLE
            } else if (checkedId == R.id.no) {
                travalHistory = false
                rootView.traval_location.visibility = View.GONE
            }
        }

        observeViewModel()
    }

    fun observeViewModel() {

        serveyModel = arguments?.getParcelable<ServeyModel>(Constants.SERVEYMODEL)!!

        rootView.person_1_name.setText(serveyModel.familyServeyModel!!.FamilyHeadPersonName)

        viewmodel.getPersonOneName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.person_1_name.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })



        viewmodel.getPersonOneName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.person_1_name.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPersonOneAge().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.age.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPersonOneTravalLoation().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.traval_location.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPersonOneMobileNumber().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.mobile_number.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.callcallPersonTwo().observe(this, object : Observer<PersonModel> {
            override fun onChanged(personModel: PersonModel) {
                serveyModel.personModelOne = personModel
                val bundle = Bundle()
                bundle.putParcelable(Constants.SERVEYMODEL,serveyModel)
                (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_PERSON_2, bundle)
            }
        })
    }


    companion object {
        fun newInstance() = PersonOneFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}

