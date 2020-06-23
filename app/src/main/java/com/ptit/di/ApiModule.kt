package com.ptit.di

import com.ptit.data.api.ApiConstants
import com.ptit.data.api.ApiFactory
import com.ptit.data.api.ApiService
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule: Module = module {

    single(named(KoinNames.FLICKR_API)) {
        ApiFactory.buildApi(
            baseUrl = ApiConstants.BASE_URL,
            restApi = ApiService::class.java,
            client = get(named(KoinNames.CLIENT)),
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.RX_JAVA_2_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.CLIENT)) {
        OkHttpClient.Builder().build()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }

    single(named(KoinNames.RX_JAVA_2_CALL_ADAPTER_FACTORY)) {
        RxJava2CallAdapterFactory.create()
    }
}
