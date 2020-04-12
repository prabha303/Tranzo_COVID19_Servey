package com.covid91.tranzo.ui.tranzo.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.lynkdriver.lynk.factory.ViewModelFactory
import com.covid91.tranzo.R
import com.covid91.tranzo.base.Constants
import com.covid91.tranzo.ui.base.BaseActivity
import com.covid91.tranzo.ui.base.DialogUtil
import com.covid91.tranzo.ui.tranzo.model.ServeyModel
import com.covid91.tranzo.ui.tranzo.viewmodel.TranzoSurveyViewModel
import javax.inject.Inject


class TranzoSurveillanceActivity : BaseActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    var permissionDenied = false
    private lateinit var  tranzoSurveyViewModel : TranzoSurveyViewModel
    var currentFragment: Fragment? = null

    var serveyModel = ServeyModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tranzo_main)
        tranzoSurveyViewModel = ViewModelProviders.of(this, viewModelFactory).get(TranzoSurveyViewModel::class.java)
        initializeLocation()
    }




    fun addNewSurvey(view: View) {
        loadFragment(Constants.FIRST_SURVEY_FRAGMENT, null)
    }

    fun loadFragment(fragmentId: Int, data: Bundle?) {
        val fragment = TransoSurveyFragmentLoader.loadFragment(this, fragmentId, data)
        if (fragment != null) {
            currentFragment = fragment
        }
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
        DialogUtil.showAlertDialogOnlyOk(this,false,"Location Permission Required".toString(),"Location permission required",
            "Ok",object :DialogUtil.ConfirmCallBack{
                override fun confirmed(success: Boolean) {
                    initializeLocation()
                }
            })
    }


}
