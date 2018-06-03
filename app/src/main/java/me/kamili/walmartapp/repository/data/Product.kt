package me.kamili.walmartapp.repository.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product (
    @SerializedName("longDescription") var longDescription: String? = null,
    @SerializedName("twoThreeDayShippingRate") var twoThreeDayShippingRate: Double = 0.toDouble(),
    @SerializedName("largeImage") var largeImage: String? = null,
    @SerializedName("color") var color: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("categoryNode") var categoryNode: String? = null,
    @SerializedName("mediumImage") var mediumImage: String? = null,
    @SerializedName("variants") var variants: List<Int>? = null,
    @SerializedName("productTrackingUrl") var productTrackingUrl: String? = null,
    @SerializedName("parentItemId") var parentItemId: Int = 0,
    @SerializedName("standardShipRate") var standardShipRate: Double = 0.toDouble(),
    @SerializedName("msrp") var msrp: Double = 0.toDouble(),
    @SerializedName("clearance") var clearance: Boolean = false,
    @SerializedName("preOrder") var preOrder: Boolean = false,
    @SerializedName("thumbnailImage") var thumbnailImage: String? = null,
    @SerializedName("stock") var stock: String? = null,
    @SerializedName("bundle") var bundle: Boolean = false,
    @SerializedName("brandName") var brandName: String? = null,
    @SerializedName("addToCartUrl") var addToCartUrl: String? = null,
    @SerializedName("marketplace") var marketplace: Boolean = false,
    @SerializedName("salePrice") var salePrice: Double = 0.toDouble(),
    @SerializedName("categoryPath") var categoryPath: String? = null,
    @SerializedName("upc") var upc: String? = null,
    @SerializedName("shortDescription") var shortDescription: String? = null,
    @SerializedName("sellerInfo") var sellerInfo: String? = null,
    @SerializedName("itemId") var itemId: Int = 0,
    @SerializedName("size") var size: String? = null,
    @SerializedName("affiliateAddToCartUrl") var affiliateAddToCartUrl: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("modelNumber") var modelNumber: String? = null,
    @SerializedName("attributes") var attributes: Attributes? = null,
    @SerializedName("availableOnline") var availableOnline: Boolean = false,
    @SerializedName("productUrl") var productUrl: String? = null,
    @SerializedName("freeShippingOver50Dollars") var freeShippingOver50Dollars: Boolean = false
) : Parcelable