package com.covid91.tranzo.ui.service

import android.location.Address
import android.location.Location
import com.covid91.tranzo.ui.tranzo.model.AddressModel

interface ILocationUpdater {

    fun onLocationChanged(address: AddressModel)
}