package com.covid91.tranzo.ui.tranzo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.covid91.tranzo.base.BaseViewModel
import com.covid91.tranzo.ui.tranzo.model.CovidSymptoms
import com.covid91.tranzo.ui.tranzo.model.FamilyServeyModel
import com.covid91.tranzo.ui.tranzo.model.OtherHealthIssues
import com.covid91.tranzo.ui.tranzo.model.PersonModel
import javax.inject.Inject


class TranzoSurveyViewModel @Inject constructor() :  BaseViewModel(){

     var familyServeyModel: FamilyServeyModel? = null

    val PersonModel = PersonModel()
    val covidSymptomsPersonOne = CovidSymptoms()
    val otherHealthIssuesPersonOne = OtherHealthIssues()

    private val validateServeyArea = MutableLiveData<String>()
    private val validateDoorNo = MutableLiveData<String>()
    private val validateStreetName = MutableLiveData<String>()
    private val validateFamilyHeadName = MutableLiveData<String>()
    private val validatePeopleStayingCount = MutableLiveData<String>()
    private val validateAgedPeopleCount = MutableLiveData<String>()
    private val validateKidsBelow10Count = MutableLiveData<String>()
    fun getServeyArea() = validateServeyArea
    fun getDoorNo() = validateDoorNo
    fun getStreetName() = validateStreetName
    fun getFamilyHeadName() = validateFamilyHeadName
    fun getPeopleStayingCount() = validatePeopleStayingCount
    fun getAgedPeopleCount() = validateAgedPeopleCount
    fun getKidsBelow10CountVal() = validateKidsBelow10Count
    private val callNext = MutableLiveData<FamilyServeyModel>()
    fun callPersonOneNext() = callNext


    private val validatePersonOneName = MutableLiveData<String>()
    fun getPersonOneName() = validatePersonOneName
    private val validatePersonOneAge = MutableLiveData<String>()
    fun getPersonOneAge() = validatePersonOneAge
    private val validatePersonOneTravalLoation = MutableLiveData<String>()
    fun getPersonOneTravalLoation() = validatePersonOneTravalLoation

    private val validatePersonOneMobileNumber = MutableLiveData<String>()
    fun getPersonOneMobileNumber() = validatePersonOneMobileNumber

    private val callPersonOne = MutableLiveData<PersonModel>()
    fun callcallPersonTwo() = callPersonOne






        fun validateFamiliy(serveyAea: String, doorNO: String, streetName: String, familyHeadName:String,
                            numberOfPeopleStayingCount: String, agedPeopleCount: String,kidsBelow10Count: String, address: String, areaName : String) {
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
                    familyServeyModel = FamilyServeyModel()
                    familyServeyModel?.ServeyArea = serveyAea
                    familyServeyModel?.DoorNO = doorNO
                    familyServeyModel?.StreetName =streetName
                    familyServeyModel?.FamilyHeadPersonName =familyHeadName
                    familyServeyModel?.NumberOfPeopleStayingCount = peopleStayingCount
                    familyServeyModel?.AgedPeopleCount = agedPeopleCountVal
                    familyServeyModel?.KidsBelow10Count = kidsBelow10CountVal
                    familyServeyModel?.Address = address
                    familyServeyModel?.AreaName = areaName
                    callNext.postValue(familyServeyModel)
                }
            }
        }



        fun validatePersonOne(personName : String, gender: String, age : String, mobileNumber: String, travalHistory: Boolean,travalLocation: String, treatments_any : String,other_specific: String ) {

            var ageVal = 0
            if (age.length != 0 && !age.isEmpty()) {
                ageVal = age.toInt()
            }



            when {
                personName.isEmpty() || personName.length == 0 -> {
                    validatePersonOneName.postValue("Enter person Name")
                }
                ageVal <= 0 -> {
                    validatePersonOneAge.postValue("Enter valid age")
                }
                mobileNumber.isEmpty() || mobileNumber.length != 10 -> {
                    validatePersonOneMobileNumber.postValue("Enter valid mobile number")
                }
                travalHistory && (travalLocation.isEmpty() || travalLocation.length == 0 ) -> {
                    validatePersonOneTravalLoation.postValue("Enter traval location")
                } else -> {

                PersonModel.PersonName = personName
                PersonModel.Gender =gender
                PersonModel.Age = ageVal
                PersonModel.MobileNumber = mobileNumber
                PersonModel.TravelLocation = travalLocation
                PersonModel.TravalHistory = travalHistory
                PersonModel.CovidSymptoms = covidSymptomsPersonOne
                PersonModel.OtherHealthIssues = otherHealthIssuesPersonOne
                PersonModel.TreatmentsIfAny = treatments_any
                PersonModel.OtherSpecificIllness = other_specific
                callPersonOne.postValue(PersonModel)
            }
            }
        }
    }

