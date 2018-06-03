package me.kamili.walmartapp.repository.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class ResponseProducts (
    @SerializedName("nextPage") var nextPage: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("items") var items: List<Product>? = null
)