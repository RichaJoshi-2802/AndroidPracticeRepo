package com.example.sqlitedatabasedemo

import android.os.Parcel
import android.os.Parcelable

data class UserModal(
    val name: String?,
    val email: String?,
    val gender: String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModal> {
        override fun createFromParcel(parcel: Parcel): UserModal {
            return UserModal(parcel)
        }

        override fun newArray(size: Int): Array<UserModal?> {
            return arrayOfNulls(size)
        }
    }
}