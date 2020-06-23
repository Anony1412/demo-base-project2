package com.ptit.data.repository

import com.ptit.data.source.UserDataSource
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.Single

class UserRepository private constructor(
    private val userRemoteDataSource: UserDataSource.Remote
) {

    fun findUserByUsername(username: String): Single<UserResponse> =
        userRemoteDataSource.findUserByUsername(username)

    companion object {

        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userRemoteDataSource: UserDataSource.Remote): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userRemoteDataSource)
            }
    }
}
