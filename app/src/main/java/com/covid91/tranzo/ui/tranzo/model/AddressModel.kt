package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class AddressModel() {
    @SerializedName("address")
    var Address: String? = ""

    @SerializedName("area")
    var Area: String? = ""


}
