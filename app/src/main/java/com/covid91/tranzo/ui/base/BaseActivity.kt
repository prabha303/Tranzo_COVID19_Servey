package com.covid91.tranzo.ui.base

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //LocationUtil.getInstance().LocationService(this, this)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

    }


    companion object {
        private const val LOCATION_PERMISSION_CODE = 1000
    }

    private lateinit var requestPermissionCallback: RequestPermissionCallback

    interface RequestPermissionCallback {
        fun onPermissionGranted()
        fun onPermissionDenied()
    }



    fun checkLocationPermission(context: Context, callback: RequestPermissionCallback) {
        requestPermissionCallback = callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val hasBackgroundLocationPermission = ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
                    if (hasBackgroundLocationPermission) {
                        // handle location update
                        requestPermissionCallback.onPermissionGranted()
                    } else {
                        requestPermissions(arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION), LOCATION_PERMISSION_CODE)
                    }
                }else
                    requestPermissionCallback.onPermissionGranted()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_BACKGROUND_LOCATION), LOCATION_PERMISSION_CODE)
                else
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION_CODE)
            }
        } else {
            requestPermissionCallback.onPermissionGranted()
        }
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        var isPermissionGranted = grantResults.isNotEmpty()
        for(i in permissions.indices){
            val permission = permissions[i]
            val  grantResult = grantResults[i]
            if (grantResult != PackageManager.PERMISSION_GRANTED && permission != Manifest.permission.ACCESS_BACKGROUND_LOCATION) {
                 isPermissionGranted = false
                 break
             }
        }

      /*  grantResults.forEach {
            if (it != PackageManager.PERMISSION_GRANTED) {
                isPermissionGranted = false
                return@forEach
            }
        }*/

        if (isPermissionGranted) {
            requestPermissionCallback.onPermissionGranted()
        } else {
            requestPermissionCallback.onPermissionDenied()
        }
    }





    fun keepScreenOn(activity: Activity) {
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

}
