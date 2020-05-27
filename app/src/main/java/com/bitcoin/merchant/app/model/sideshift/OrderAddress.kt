package com.bitcoin.merchant.app.model.sideshift

import com.google.gson.annotations.SerializedName
import org.bitcoindotcom.bchprocessor.bip70.GsonHelper

data class OrderAddress @JvmOverloads constructor(
        @SerializedName("address") var address: String)
{
    companion object {
        @JvmStatic
        fun fromJson(message: String): OrderAddress {
            return GsonHelper.gson.fromJson(message, OrderAddress::class.java)
        }
    }
}