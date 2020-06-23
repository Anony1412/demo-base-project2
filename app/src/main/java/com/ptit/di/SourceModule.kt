package com.ptit.di

import com.ptit.data.repository.UserRepository
import com.ptit.data.source.remote.UserRemoteDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.USER_REPOSITORY)) {
        UserRepository(get(named(KoinNames.USER_REMOTE_DATASOURCE)))
    }

    single(named(KoinNames.USER_REMOTE_DATASOURCE)) {
        UserRemoteDataSource(get(named(KoinNames.FLICKR_API)))
    }
}
