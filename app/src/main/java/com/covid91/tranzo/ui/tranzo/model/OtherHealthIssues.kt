package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class OtherHealthIssues() : Parcelable {
    @SerializedName("Diabetes")
    var Diabetes: Boolean = false

    @SerializedName("blood_pressure")
    var BloodPressure: Boolean = false


    @SerializedName("Respiratory")
    var Respiratory: Boolean = false

    constructor(parcel: Parcel) : this() {
        Diabetes = parcel.readByte() != 0.toByte()
        BloodPressure = parcel.readByte() != 0.toByte()
        Respiratory = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (Diabetes) 1 else 0)
        parcel.writeByte(if (BloodPressure) 1 else 0)
        parcel.writeByte(if (Respiratory) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OtherHealthIssues> {
        override fun createFromParcel(parcel: Parcel): OtherHealthIssues {
            return OtherHealthIssues(parcel)
        }

        override fun newArray(size: Int): Array<OtherHealthIssues?> {
            return arrayOfNulls(size)
        }
    }
}