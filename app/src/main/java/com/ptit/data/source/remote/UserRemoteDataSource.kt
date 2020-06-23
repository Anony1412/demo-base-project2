package com.ptit.data.source.remote

import com.ptit.data.api.ApiService
import com.ptit.data.source.UserDataSource
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.Single

class UserRemoteDataSource (private val apiService: ApiService) : UserDataSource.Remote {

    override fun findUserByUsername(username: String): Single<UserResponse> =
        apiService.findUserByUsername(username)
}
