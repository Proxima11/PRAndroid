package kris.ks.prandorid

import android.os.Parcel
import android.os.Parcelable

data class HistoryCalc(
    val operation:String?,
    val result:Int?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(operation)
        parcel.writeValue(result)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HistoryCalc> {
        override fun createFromParcel(parcel: Parcel): HistoryCalc {
            return HistoryCalc(parcel)
        }

        override fun newArray(size: Int): Array<HistoryCalc?> {
            return arrayOfNulls(size)
        }
    }
}
