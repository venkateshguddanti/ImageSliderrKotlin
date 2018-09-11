package org.hm.com.imageslider

import android.os.Parcel
import android.os.Parcelable

data class SliderItem(val title: String) : Parcelable {


    var url :String =""
    var resId : Int ? = null

    constructor(parcel: Parcel) : this(parcel.readString()) {
        url = parcel.readString()
        resId = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    constructor(title: String, resID : Int) : this(title)
    {
            this.resId = resID
    }

    constructor(title: String, url : String) : this(title)
    {
        this.url = url
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeValue(resId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SliderItem> {
        override fun createFromParcel(parcel: Parcel): SliderItem {
            return SliderItem(parcel)
        }

        override fun newArray(size: Int): Array<SliderItem?> {
            return arrayOfNulls(size)
        }
    }


}