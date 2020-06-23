package com.ptit.utils

import com.ptit.data.api.ApiConstants
import com.ptit.data.api.ApiMethod
import com.ptit.ui.BuildConfig

object Request {

    const val URL_FIND_USER_BY_USER_NAME =
        ApiConstants.PATH_SERVICE + Character.CHARACTER_ITALIC +
                ApiConstants.PATH_REST + Character.CHARACTER_ITALIC +
                Character.CHARACTER_ANY +
                ApiConstants.QUERY_METHOD + Character.CHARACTER_EQUAL +
                ApiMethod.METHOD_FIND_USER_BY_USER_NAME + Character.CHARACTER_AND +
                ApiConstants.QUERY_API_KEY + Character.CHARACTER_EQUAL +
                BuildConfig.API_KEY + Character.CHARACTER_AND +
                ApiConstants.QUERY_FORMAT + Character.CHARACTER_EQUAL +
                ApiConstants.VALUE_JSON + Character.CHARACTER_AND +
                ApiConstants.QUERY_NO_JSON_CALLBACK + Character.CHARACTER_EQUAL +
                ApiConstants.VALUE_ANY
}
