package com.covid91.tranzo.ui.service

import android.location.Address
import android.location.Location

interface ILocationUpdater {

    fun onLocationChanged(address: String)
}