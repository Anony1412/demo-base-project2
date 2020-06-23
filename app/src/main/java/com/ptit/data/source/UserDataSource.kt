package com.ptit.data.source

import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.Single

interface UserDataSource {

    interface Remote {
        fun findUserByUsername(username: String): Single<UserResponse>
    }
}
