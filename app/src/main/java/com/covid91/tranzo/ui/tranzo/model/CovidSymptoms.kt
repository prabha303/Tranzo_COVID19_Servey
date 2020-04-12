package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class CovidSymptoms() : Parcelable {

    @SerializedName("cold")
    var Cold: Boolean = false

    @SerializedName("cough")
    var Cough: Boolean = false

    @SerializedName("fever")
    var Fever: Boolean = false

    @SerializedName("tiredness")
    var Tiredness: Boolean = false

    constructor(parcel: Parcel) : this() {
        Cold = parcel.readByte() != 0.toByte()
        Cough = parcel.readByte() != 0.toByte()
        Fever = parcel.readByte() != 0.toByte()
        Tiredness = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (Cold) 1 else 0)
        parcel.writeByte(if (Cough) 1 else 0)
        parcel.writeByte(if (Fever) 1 else 0)
        parcel.writeByte(if (Tiredness) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CovidSymptoms> {
        override fun createFromParcel(parcel: Parcel): CovidSymptoms {
            return CovidSymptoms(parcel)
        }

        override fun newArray(size: Int): Array<CovidSymptoms?> {
            return arrayOfNulls(size)
        }
    }
}