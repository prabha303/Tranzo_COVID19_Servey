package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.base.sharedpreference.SharedPref
import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.tranzo.model.PersonModel
import com.covid91.tranzo.ui.tranzo.model.ServeyModel
import com.covid91.tranzo.ui.tranzo.viewmodel.PersonTwoViewModel
import com.google.gson.Gson
import com.lynkdriver.lynk.factory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_person_one.view.*
import kotlinx.android.synthetic.main.fragment_person_two.view.*
import kotlinx.android.synthetic.main.fragment_person_two.view.age
import kotlinx.android.synthetic.main.fragment_person_two.view.blood_pressure
import kotlinx.android.synthetic.main.fragment_person_two.view.cold
import kotlinx.android.synthetic.main.fragment_person_two.view.cough
import kotlinx.android.synthetic.main.fragment_person_two.view.diabetes
import kotlinx.android.synthetic.main.fragment_person_two.view.fever
import kotlinx.android.synthetic.main.fragment_person_two.view.gender_radio
import kotlinx.android.synthetic.main.fragment_person_two.view.mobile_number
import kotlinx.android.synthetic.main.fragment_person_two.view.next
import kotlinx.android.synthetic.main.fragment_person_two.view.other_specific_illness
import kotlinx.android.synthetic.main.fragment_person_two.view.previous
import kotlinx.android.synthetic.main.fragment_person_two.view.radioGroup
import kotlinx.android.synthetic.main.fragment_person_two.view.respiratory
import kotlinx.android.synthetic.main.fragment_person_two.view.tiredness
import kotlinx.android.synthetic.main.fragment_person_two.view.traval_location
import kotlinx.android.synthetic.main.fragment_person_two.view.treatments_any
import javax.inject.Inject


class PersonTwoFragment constructor() : BaseFragment() {

    lateinit var rootView: View
    private lateinit var mContext: Context
    lateinit var serveyModel: ServeyModel
    lateinit var personOneModel: PersonModel
    var travalHistory = false

    @Inject
    lateinit var viewmodelfactory: ViewModelFactory
    lateinit var viewmodel: PersonTwoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_person_two, container, false)
        return rootView
    }

    companion object {
        fun newInstance() = PersonTwoFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(PersonTwoViewModel::class.java)

        serveyModel = arguments?.getParcelable<ServeyModel>(Constants.SERVEYMODEL)!!


        rootView.next.setOnClickListener {

            viewmodel.covidSymptomsPersonTwo.Cold =rootView.cold.isChecked
            viewmodel.covidSymptomsPersonTwo.Cough =rootView.cough.isChecked
            viewmodel.covidSymptomsPersonTwo.Fever =rootView.fever.isChecked
            viewmodel.covidSymptomsPersonTwo.Tiredness =rootView.tiredness.isChecked

            viewmodel.otherHealthIssuesPersonTwo.BloodPressure = rootView.blood_pressure.isChecked
            viewmodel.otherHealthIssuesPersonTwo.Diabetes = rootView.diabetes.isChecked
            viewmodel.otherHealthIssuesPersonTwo.Respiratory = rootView.respiratory.isChecked

            val genid: Int = rootView.gender_radio.getCheckedRadioButtonId()
            val radioButton = rootView.findViewById(genid) as RadioButton
            val gender = radioButton.text.toString()
            viewmodel.validatePersonOne(
                rootView.person_2_name.text.toString(),
                gender,
                rootView.age.text.toString(),
                rootView.mobile_number.text.toString(),
                travalHistory,
                rootView.traval_location.text.toString(),
                rootView.treatments_any.text.toString(),
                rootView.other_specific_illness.text.toString())
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
        viewmodel.getPersonTwoName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.person_1_name.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.getPersonTwoName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.person_1_name.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPersonTwoAge().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.age.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPersonTwoTravalLoation().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.traval_location.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.getPersonTwoMobileNumber().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.mobile_number.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.callcallPersonTwo().observe(this, object : Observer<PersonModel> {
            override fun onChanged(personTwoModel: PersonModel) {

                val gson = Gson()
                val json = gson.toJson(serveyModel)
                SharedPref.setSharedValue(mContext, Constants.SERVEYMODEL, json)
                val sM = SharedPref.getStringValue(mContext, Constants.SERVEYMODEL)
                Log.d("sM","--"+sM)


                serveyModel.personModelTwo = personTwoModel
                val bundle = Bundle()
                bundle.putParcelable(Constants.SERVEYMODEL,serveyModel)
                (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_GENERSL_INFO, bundle)
            }
        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}

