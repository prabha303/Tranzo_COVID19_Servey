package com.covid91.tranzo.ui.repository

import com.covid91.tranzo.base.BaseRepository
import com.covid91.tranzo.network.NetworkCallback
import javax.inject.Inject


 private  const val APIKEY = "DEMO_KEY"
 private  const val FUELTYPE = "E85,ELEC"
 private  const val STATE = "CA"
 private  const val limit = 100

class FuelStationRepository @Inject constructor(var fuelStationApiService: FuelStationApiService): BaseRepository() {
    fun getFuelStationlist(networkCallback: NetworkCallback) {
        makeNetworkCall(fuelStationApiService.getFuelDetail(APIKEY,FUELTYPE, STATE, limit),networkCallback)
    }
}