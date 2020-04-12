package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
class ServeyModel() : Parcelable{

    @SerializedName("family_servey_model")
    var familyServeyModel: FamilyServeyModel? = null

    @SerializedName("person_one")
    var personModelOne: PersonModel? = null

    @SerializedName("person_two")
    var personModelTwo: PersonModel? = null

    constructor(parcel: Parcel) : this() {
        familyServeyModel = parcel.readParcelable(FamilyServeyModel::class.java.classLoader)
        personModelOne = parcel.readParcelable(PersonModel::class.java.classLoader)
        personModelTwo = parcel.readParcelable(PersonModel::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(familyServeyModel, flags)
        parcel.writeParcelable(personModelOne, flags)
        parcel.writeParcelable(personModelTwo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServeyModel> {
        override fun createFromParcel(parcel: Parcel): ServeyModel {
            return ServeyModel(parcel)
        }

        override fun newArray(size: Int): Array<ServeyModel?> {
            return arrayOfNulls(size)
        }
    }


}
