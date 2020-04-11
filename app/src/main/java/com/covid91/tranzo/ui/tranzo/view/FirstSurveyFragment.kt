package com.covid91.tranzo.ui.tranzo.view

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseFragment
import com.covid91.tranzo.ui.service.ILocationUpdater
import com.covid91.tranzo.ui.service.LocationUtil
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import com.lynkdriver.lynk.factory.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_first_servey.*
import kotlinx.android.synthetic.main.fragment_first_servey.view.*
import javax.inject.Inject

class FirstSurveyFragment : BaseFragment(), ILocationUpdater {

    lateinit var rootView: View
    private lateinit var mContext: Context

    @Inject
    lateinit var viewmodelfactory: ViewModelFactory
    lateinit var viewmodel : TranzoSurveyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_first_servey, container, false)
        LocationUtil.getInstance().LocationService(mContext,this)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this,viewmodelfactory).get(TranzoSurveyViewModel::class.java)
        rootView.save_and_continue.setOnClickListener {
            viewmodel.validateFamiliy(
                rootView.servey_area.text.toString(),
                rootView.door_no.text.toString(),
                rootView.street_name.text.toString(),
                rootView.family_head_name_person.text.toString(),
                rootView.number_of_people_staying_count.text.toString(),
                rootView.aged_people_count.text.toString(),
                rootView.kids_below10_count.text.toString())
        }
        calculateValues()
        observeLoginViewModel()
    }

    companion object {
        fun newInstance() = FirstSurveyFragment()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onLocationChanged(address: String) {
        Log.d("onLocationChanged", "location : $address")
        rootView.address.setText(address)
    }



    fun observeLoginViewModel() {

        viewmodel.getServeyArea().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.servey_area.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getDoorNo().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.door_no.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.getStreetName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.street_name.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.getFamilyHeadName().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.family_head_name_person.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getPeopleStayingCount().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.number_of_people_staying_count.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })

        viewmodel.getAgedPeopleCount().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.aged_people_count.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.getKidsBelow10CountVal().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                rootView.kids_below10_count.setError(errorString)
                Toast.makeText(mContext,errorString, Toast.LENGTH_LONG).show()
            }
        })
        viewmodel.callPersonOneNext().observe(this, object : Observer<String> {
            override fun onChanged(errorString: String?) {
                (mContext as TranzoSurveillanceActivity).loadFragment(Constants.FRAGMENT_PERSON_1, null)
            }
        })

    }

    fun calculateValues() {
        rootView.number_of_people_staying_minus_quantity.setOnClickListener {
            number_of_people_staying_count.setError(null)
            val count = (number_of_people_staying_count.text.toString()).toInt() - 1
            if (count >= 0)
            rootView.number_of_people_staying_count.text = "" + count
        }
        rootView.number_of_people_staying_add_quantity.setOnClickListener {
            number_of_people_staying_count.setError(null)
            val count = (number_of_people_staying_count.text.toString()).toInt() + 1
            rootView.number_of_people_staying_count.text = "" + count
        }

        rootView.aged_people_minus_quantity.setOnClickListener {
            aged_people_count.setError(null)
            val count = (aged_people_count.text.toString()).toInt() - 1
            if (count >= 0)
            rootView.aged_people_count.text = "" + count
        }
        rootView.aged_people_add_quantity.setOnClickListener {
            aged_people_count.setError(null)
            val count = (aged_people_count.text.toString()).toInt() + 1
            rootView.aged_people_count.text = "" + count
        }

        rootView.minus_kids_quantity.setOnClickListener {
            kids_below10_count.setError(null)
            val count = (kids_below10_count.text.toString()).toInt() - 1
            if (count >= 0)
            rootView.kids_below10_count.text = "" + count
        }
        rootView.add_kids_quantity.setOnClickListener {
            kids_below10_count.setError(null)
            val count = (kids_below10_count.text.toString()).toInt() + 1
            rootView.kids_below10_count.text = "" + count
        }
    }
}

