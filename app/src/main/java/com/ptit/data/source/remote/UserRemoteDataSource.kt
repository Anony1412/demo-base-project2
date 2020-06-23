package com.ptit.data.source.remote

import com.ptit.data.api.ApiService
import com.ptit.data.source.UserDataSource
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.Single

class UserRemoteDataSource private constructor(
    private val apiService: ApiService
) : UserDataSource.Remote {

    override fun findUserByUsername(username: String): Single<UserResponse> =
        apiService.findUserByUsername(username)

    companion object {

        @Volatile
        private var instance: UserDataSource.Remote? = null

        fun getInstance(apiService: ApiService): UserDataSource.Remote =
            instance ?: synchronized(this) {
                instance ?: UserRemoteDataSource(apiService)
            }
    }
}
