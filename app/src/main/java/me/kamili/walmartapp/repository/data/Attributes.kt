package me.kamili.walmartapp.repository.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Attributes(
    @SerializedName("color") val color: String? = null,
    @SerializedName("size") val size: String? = null,
    @SerializedName("canonicalUrl") val canonicalUrl: String? = null
) :Parcelable