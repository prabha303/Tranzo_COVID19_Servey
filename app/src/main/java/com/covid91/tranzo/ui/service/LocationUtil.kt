package com.covid91.tranzo.ui.service

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.AsyncTask
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.util.Log.e
import com.covid91.tranzo.ui.tranzo.model.AddressModel
import com.google.android.gms.location.*
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class LocationUtil private constructor() {
    var mFusedLocationClient: FusedLocationProviderClient? = null
    var mSettingsClient: SettingsClient? = null
    var mLocationRequest: LocationRequest? = null
    var mLocationSettingsRequest: LocationSettingsRequest? = null
    var mLocationCallback: LocationCallback? = null
    var mCurrentLocation: Location? = null
    var UPDATE_INTERVAL_IN_MILLISECONDS: Long = 120 * 1000

    var context : Context? = null
    var updateInterService : ILocationUpdater? = null
    var previousUpdates : Long? = 0L
    var resultAdress = ""
    companion object {
        @SuppressLint("StaticFieldLeak")
        var locationUtil: LocationUtil? = null
        fun getInstance(): LocationUtil {
            if (locationUtil == null) {
                locationUtil = LocationUtil()
            }
            return locationUtil!!
        }
    }

    fun LocationService(context: Context, mServiceManager: ILocationUpdater) {
        try {
            this.context = context
            this.updateInterService = mServiceManager
            startLocationUpdates()
        } catch (e: Exception) {
             e("LocationUtil", "Error : ${e.stackTrace}")
        }
    }

    fun startLocationUpdates(){
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!)
        mSettingsClient = LocationServices.getSettingsClient(context!!)
        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                try {
                        mCurrentLocation = locationResult!!.lastLocation
                        if (mCurrentLocation != null) {
                            if (TextUtils.isEmpty(resultAdress)) {
                                Log.d("LocationUtil", "New Location : ${mCurrentLocation!!.latitude}, ${mCurrentLocation!!.longitude}")
                                val now = System.currentTimeMillis()
                                if (previousUpdates!!.compareTo(0) > 0) {
                                    val diff = TimeUnit.MILLISECONDS.toSeconds(now - previousUpdates!!)
                                    if (diff.compareTo(5) < 0) return
                                }
                                previousUpdates = now
                                GetAddressTask(context!!,updateInterService!!).execute(mCurrentLocation!!)
                            }
                        }
                } catch (e: Exception) {
                    e("LocationUtil", "Error mgd : ${e.message}")
                }
            }
        }
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        val builder = LocationSettingsRequest.Builder()
        builder.addLocationRequest(mLocationRequest!!)
        mLocationSettingsRequest = builder.build()
        mFusedLocationClient!!.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())

    }



    class GetAddressTask(val context: Context,val updateInterService : ILocationUpdater): AsyncTask<Location, Void, AddressModel>() {
        override fun doInBackground(vararg params: Location?): AddressModel? {
            try {
                val geocoder = Geocoder(context, Locale.getDefault())
                var addresses: List<Address>? = null
                try {
                    addresses = geocoder.getFromLocation(params[0]!!.latitude, params[0]!!.longitude, 1)
                } catch (ioException: IOException) {
                    ioException.printStackTrace()
                }
                val address = addresses!![0]
                val out = StringBuilder()
                for (i in 0..address.maxAddressLineIndex) {
                    out.append(address.getAddressLine(i))
                    address.adminArea
                }
                val addressModel = AddressModel()
                addressModel.Address = out.toString()
                addressModel.Area = address.adminArea
                return addressModel
            }catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
        override fun onPostExecute(result: AddressModel) {
            if(!TextUtils.isEmpty(result.Address)) {
                getInstance().resultAdress = result.Address!!
                updateInterService.onLocationChanged(result)
            }
        }
    }

    }








