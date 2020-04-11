package com.covid91.tranzo.ui.tranzo.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class FamilyServeyModel {
    @SerializedName("servey_area")
    var ServeyArea: String = ""

    @SerializedName("door_no")
    var DoorNO: String = ""

    @SerializedName("street_name")
    var StreetName: String = ""

    @SerializedName("family_head_name_person")
    var FamilyHeadPersonName: String = ""

    @SerializedName("number_of_people_staying_count")
    var NumberOfPeopleStayingCount: Int = 0
    @SerializedName("aged_people_count")
    var AgedPeopleCount: Int = 0

    @SerializedName("kids_below10_count")
    var KidsBelow10Count: Int = 0

}
