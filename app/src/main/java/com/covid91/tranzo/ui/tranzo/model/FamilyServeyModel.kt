package com.covid91.tranzo.ui.tranzo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class FamilyServeyModel() : Parcelable {
    @SerializedName("servey_area")
    var ServeyArea: String? = ""

    @SerializedName("door_no")
    var DoorNO: String? = ""

    @SerializedName("street_name")
    var StreetName: String? = ""

    @SerializedName("family_head_name_person")
    var FamilyHeadPersonName: String? = ""

    @SerializedName("number_of_people_staying_count")
    var NumberOfPeopleStayingCount: Int = 0
    @SerializedName("aged_people_count")
    var AgedPeopleCount: Int = 0

    @SerializedName("kids_below10_count")
    var KidsBelow10Count: Int = 0

    @SerializedName("address")
    var Address: String? = ""

    @SerializedName("area_name")
    var AreaName: String? = ""

    constructor(parcel: Parcel) : this() {
        ServeyArea = parcel.readString()
        DoorNO = parcel.readString()
        StreetName = parcel.readString()
        FamilyHeadPersonName = parcel.readString()
        NumberOfPeopleStayingCount = parcel.readInt()
        AgedPeopleCount = parcel.readInt()
        KidsBelow10Count = parcel.readInt()
        Address = parcel.readString()
        AreaName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ServeyArea)
        parcel.writeString(DoorNO)
        parcel.writeString(StreetName)
        parcel.writeString(FamilyHeadPersonName)
        parcel.writeInt(NumberOfPeopleStayingCount)
        parcel.writeInt(AgedPeopleCount)
        parcel.writeInt(KidsBelow10Count)
        parcel.writeString(Address)
        parcel.writeString(AreaName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FamilyServeyModel> {
        override fun createFromParcel(parcel: Parcel): FamilyServeyModel {
            return FamilyServeyModel(parcel)
        }

        override fun newArray(size: Int): Array<FamilyServeyModel?> {
            return arrayOfNulls(size)
        }
    }


}
