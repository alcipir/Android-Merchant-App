package com.bitcoin.merchant.app.model.sideshift

import com.google.gson.annotations.SerializedName
import org.bitcoindotcom.bchprocessor.bip70.GsonHelper

data class OrderResponse @JvmOverloads constructor(
        @SerializedName("depositAddress") var depositAddress: OrderAddress)
    {
    companion object {
        @JvmStatic
        fun fromJson(message: String): OrderResponse {
            return GsonHelper.gson.fromJson(message, OrderResponse::class.java)
        }
    }
}