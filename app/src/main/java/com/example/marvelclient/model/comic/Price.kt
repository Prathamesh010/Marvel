package com.example.marvelclient.model.comic


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Price(
    @SerializedName("price")
    val price: Double,
    @SerializedName("type")
    val type: String
) : Parcelable