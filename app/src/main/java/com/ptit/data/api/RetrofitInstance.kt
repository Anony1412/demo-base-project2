package com.ptit.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance private constructor() {

    companion object {

        @Volatile
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit =
            instance ?: synchronized(this) {
                instance ?: Retrofit.Builder()
                    .baseUrl(ApiConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().also { instance = it }
            }
    }
}

