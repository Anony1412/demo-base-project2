package com.ptit.data.api

import com.ptit.data.source.remote.response.UserResponse
import com.ptit.utils.Request
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Request.URL_FIND_USER_BY_USER_NAME)
    fun findUserByUsername (
        @Query(ApiConstants.QUERY_USERNAME) username: String
    ): Single<UserResponse>
}
