package com.covid91.tranzo.ui.tranzo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.covid91.tranzo.base.BaseViewModel
import com.covid91.tranzo.ui.tranzo.model.FamilyServeyModel
import javax.inject.Inject


class TranzoSurveyViewModel @Inject constructor() :  BaseViewModel(){

    private val validateServeyArea = MutableLiveData<String>()
    private val validateDoorNo = MutableLiveData<String>()
    private val validateStreetName = MutableLiveData<String>()
    private val validateFamilyHeadName = MutableLiveData<String>()
    private val validatePeopleStayingCount = MutableLiveData<String>()
    private val validateAgedPeopleCount = MutableLiveData<String>()
    private val validateKidsBelow10Count = MutableLiveData<String>()

    val familyServeyModel = FamilyServeyModel()

    private val callNext = MutableLiveData<String>()
    fun getServeyArea() = validateServeyArea
    fun getDoorNo() = validateDoorNo
    fun getStreetName() = validateStreetName
    fun getFamilyHeadName() = validateFamilyHeadName
    fun getPeopleStayingCount() = validatePeopleStayingCount
    fun getAgedPeopleCount() = validateAgedPeopleCount
    fun getKidsBelow10CountVal() = validateKidsBelow10Count

    fun callPersonOneNext() = callNext



    fun validateFamiliy(serveyAea: String, doorNO: String, streetName: String, familyHeadName:String, numberOfPeopleStayingCount: String, agedPeopleCount: String,kidsBelow10Count: String) {
        var peopleStayingCount = 0
        var agedPeopleCountVal = 0
        var kidsBelow10CountVal = 0
        if (numberOfPeopleStayingCount.length != 0 && !numberOfPeopleStayingCount.isEmpty()) {
            peopleStayingCount = numberOfPeopleStayingCount.toInt()
        }
        if (agedPeopleCount.length != 0 && !agedPeopleCount.isEmpty()) {
            agedPeopleCountVal = agedPeopleCount.toInt()
        }
        if (kidsBelow10Count.length != 0 && !kidsBelow10Count.isEmpty()) {
            kidsBelow10CountVal = kidsBelow10Count.toInt()
        }
        when {
            serveyAea.isEmpty() || serveyAea.length == 0 -> {
                validateServeyArea.postValue("Enter servey area")
            }
            doorNO.isEmpty() || doorNO.length == 0 -> {
                validateDoorNo.postValue("Enter Door No. area")
            }
            streetName.isEmpty() || streetName.length == 0 -> {
                validateStreetName.postValue("Enter Street name")
            }
            familyHeadName.isEmpty() || familyHeadName.length == 0 -> {
                validateFamilyHeadName.postValue("Enter Head Family name")
            }
            peopleStayingCount <= 0 -> {
                validatePeopleStayingCount.postValue("Number of people staying with")
            }
            agedPeopleCountVal <= 0 -> {
                validateAgedPeopleCount.postValue("Number of aged people staying ? 60 +")
            }
             kidsBelow10CountVal <= 0 -> {
                validateKidsBelow10Count.postValue("Enter Kids below 10 / Infants?")
            }
            else  -> {
                familyServeyModel.ServeyArea = serveyAea
                familyServeyModel.DoorNO = doorNO
                familyServeyModel.StreetName =streetName
                familyServeyModel.FamilyHeadPersonName =familyHeadName
                familyServeyModel.NumberOfPeopleStayingCount = peopleStayingCount
                familyServeyModel.AgedPeopleCount = agedPeopleCountVal
                familyServeyModel.KidsBelow10Count = kidsBelow10CountVal

                Log.d("familyServeyModel", familyServeyModel.ServeyArea)
                callNext.postValue("Success")
            }
        }
    }










}
