package com.covid91.tranzo.ui.tranzo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.covid91.tranzo.base.BaseViewModel
import com.covid91.tranzo.ui.tranzo.model.CovidSymptoms
import com.covid91.tranzo.ui.tranzo.model.OtherHealthIssues
import com.covid91.tranzo.ui.tranzo.model.PersonModel
import javax.inject.Inject


class PersonTwoViewModel @Inject constructor() :  BaseViewModel(){

    val PersonModel = PersonModel()
    val covidSymptomsPersonTwo = CovidSymptoms()
    val otherHealthIssuesPersonTwo = OtherHealthIssues()


    private val validatePersonOneName = MutableLiveData<String>()
    fun getPersonTwoName() = validatePersonOneName
    private val validatePersonOneAge = MutableLiveData<String>()
    fun getPersonTwoAge() = validatePersonOneAge
    private val validatePersonOneTravalLoation = MutableLiveData<String>()
    fun getPersonTwoTravalLoation() = validatePersonOneTravalLoation

    private val validatePersonOneMobileNumber = MutableLiveData<String>()
    fun getPersonTwoMobileNumber() = validatePersonOneMobileNumber


    private val callPersonTwo = MutableLiveData<PersonModel>()
    fun callcallPersonTwo() = callPersonTwo

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
            !mobileNumber.isEmpty() && mobileNumber.length != 10 -> {
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
            PersonModel.CovidSymptoms = covidSymptomsPersonTwo
            PersonModel.OtherHealthIssues = otherHealthIssuesPersonTwo
            PersonModel.TreatmentsIfAny = treatments_any
            PersonModel.OtherSpecificIllness = other_specific
            callPersonTwo.postValue(PersonModel)
        }
        }
    }

    }

