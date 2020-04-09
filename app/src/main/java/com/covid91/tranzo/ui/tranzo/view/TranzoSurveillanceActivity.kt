package com.covid91.tranzo.ui.tranzo.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lynkdriver.lynk.factory.ViewModelFactory
import com.covid91.tranzo.R
import com.covid91.tranzo.ui.adapter.FuelStationAdapter
import com.covid91.tranzo.ui.base.BaseActivity
import com.covid91.tranzo.ui.base.DialogUtil
import com.covid91.tranzo.ui.di.IFragmentLoader
import com.covid91.tranzo.ui.model.FuelStationsModel
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import com.covid91.tranzo.ui.viewmodel.FuelStationViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tranzo_main.*
import java.util.*
import javax.inject.Inject


class TranzoSurveillanceActivity : BaseActivity(), IFragmentLoader{

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    var permissionDenied = false
    private lateinit var  tranzoSurveyViewModel : TranzoSurveyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranzo_main)
        tranzoSurveyViewModel = ViewModelProviders.of(this, viewModelFactory).get(TranzoSurveyViewModel::class.java)
        initializeLocation()
    }




    fun addNewSurvey(view: View) {



    }

    override fun loadFragment(fragmentId: Int, data: Bundle?) {

     }

    private fun initializeLocation() {
        checkLocationPermission(this,object :RequestPermissionCallback{
            override fun onPermissionGranted() {
                permissionDenied = false
            }

            override fun onPermissionDenied() {
                permissionDenied = true
                showAlert()
            }

        })
    }

    private fun showAlert() {
        DialogUtil.showAlertDialogOnlyOk(this,false,"Location Permission Required".toString(),"Location permission required ",
            "Ok",object :DialogUtil.ConfirmCallBack{
                override fun confirmed(success: Boolean) {
                    initializeLocation()
                }
            })
    }


}
