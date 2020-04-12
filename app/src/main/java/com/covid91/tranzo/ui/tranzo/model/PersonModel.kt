package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class PersonModel() : Parcelable{
    @SerializedName("person_name")
    var PersonName: String? = ""

    @SerializedName("gender")
    var Gender: String? = ""

    @SerializedName("age")
    var Age: Int = 0

    @SerializedName("mobile_number")
    var MobileNumber: String? = ""

    @SerializedName("travel_location")
    var TravelLocation: String? = ""


    @SerializedName("traval_history")
    var TravalHistory: Boolean = false

    @SerializedName("covid_symptoms")
    var CovidSymptoms: CovidSymptoms? = null

    @SerializedName("other_health_issues")
    var OtherHealthIssues: OtherHealthIssues? = null

    @SerializedName("treatments_if_any")
    var TreatmentsIfAny: String? = ""

    @SerializedName("other_specific_illness")
    var OtherSpecificIllness: String? = ""

    constructor(parcel: Parcel) : this() {
        PersonName = parcel.readString()
        Gender = parcel.readString()
        Age = parcel.readInt()
        MobileNumber = parcel.readString()
        TravelLocation = parcel.readString()
        TravalHistory = parcel.readByte() != 0.toByte()
        CovidSymptoms =
            parcel.readParcelable(com.covid91.tranzo.ui.tranzo.model.CovidSymptoms::class.java.classLoader)
        OtherHealthIssues =
            parcel.readParcelable(com.covid91.tranzo.ui.tranzo.model.OtherHealthIssues::class.java.classLoader)
        TreatmentsIfAny = parcel.readString()
        OtherSpecificIllness = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(PersonName)
        parcel.writeString(Gender)
        parcel.writeInt(Age)
        parcel.writeString(MobileNumber)
        parcel.writeString(TravelLocation)
        parcel.writeByte(if (TravalHistory) 1 else 0)
        parcel.writeParcelable(CovidSymptoms, flags)
        parcel.writeParcelable(OtherHealthIssues, flags)
        parcel.writeString(TreatmentsIfAny)
        parcel.writeString(OtherSpecificIllness)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonModel> {
        override fun createFromParcel(parcel: Parcel): PersonModel {
            return PersonModel(parcel)
        }

        override fun newArray(size: Int): Array<PersonModel?> {
            return arrayOfNulls(size)
        }
    }


}

