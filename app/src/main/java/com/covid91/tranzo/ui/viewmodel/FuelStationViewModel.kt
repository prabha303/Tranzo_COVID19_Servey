package com.covid91.tranzo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.covid91.tranzo.base.BaseViewModel
import com.covid91.tranzo.network.NetworkCallback
import com.covid91.tranzo.ui.model.FuelStationResponse
import com.covid91.tranzo.ui.model.FuelStationsModel
import com.covid91.tranzo.ui.repository.FuelStationRepository
import javax.inject.Inject


class FuelStationViewModel @Inject constructor(val repository : FuelStationRepository) :  BaseViewModel(){

    val fuelStationDataLiveData = MutableLiveData<ArrayList<FuelStationsModel>>()
    val fuelStationErrorDataLiveData = MutableLiveData<String>()
    val fuelStationNoDataFound = MutableLiveData<String>()
    fun observeFuelStationResponse() = fuelStationDataLiveData
    fun observeFuelStationNoDataFound() = fuelStationNoDataFound
    fun observeFuelStationErrorResponse() = fuelStationErrorDataLiveData

    init {
        repository.getFuelStationlist(object : NetworkCallback {
            override fun onSuccess(response: Any?) {
                val responseData = response as FuelStationResponse
                if (responseData.FuelStations?.size!!.compareTo(0) > 0 ) {
                    fuelStationDataLiveData.postValue(responseData.FuelStations)
                }else{
                    fuelStationNoDataFound.postValue("No fuel stations found")
                }
            }
            override fun onError(error: Throwable?) {
                fuelStationErrorDataLiveData.postValue(error!!.message)
            }
        })
    }

}
