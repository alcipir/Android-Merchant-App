package com.bitcoin.merchant.app.model.sideshift

import com.google.gson.annotations.SerializedName
import org.bitcoindotcom.bchprocessor.bip70.GsonHelper

data class OrderRequest @JvmOverloads constructor(
        @SerializedName("settleMethodId") var settleMethodId : String,
        @SerializedName("settleAddress") var settleAddress: String,
        @SerializedName("depositMethodId") var depositMethodId: String = "bch",
        @SerializedName("type") var type: String = "variable") {
    companion object {
        @JvmStatic
        fun fromJson(message: String): OrderRequest {
            val t = message
            println(t)
            return GsonHelper.gson.fromJson(message, OrderRequest::class.java)
        }
    }
}