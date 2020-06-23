package com.ptit.data.repository

import com.ptit.data.source.UserDataSource
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.Single

class UserRepository (private val userRemoteDataSource: UserDataSource.Remote) {

    fun findUserByUsername(username: String): Single<UserResponse> =
        userRemoteDataSource.findUserByUsername(username)
}
