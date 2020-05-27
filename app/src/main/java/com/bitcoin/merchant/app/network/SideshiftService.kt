package com.bitcoin.merchant.app.network

import com.bitcoin.merchant.app.model.sideshift.OrderRequest
import com.bitcoin.merchant.app.model.sideshift.OrderResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.bitcoindotcom.bchprocessor.bip70.GsonHelper
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface SideshiftService {
    @POST("orders")
    fun createOrder(@Body r: OrderRequest): Call<OrderResponse?>

    companion object {
        fun create(baseUrl: String): SideshiftService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(GsonHelper.gson))
                    .client(httpClient.build())
                    .build()
                    .create(SideshiftService::class.java)
        }
    }
}