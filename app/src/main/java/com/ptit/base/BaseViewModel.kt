package com.ptit.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    val messageErrorLiveData = MutableLiveData<String>()
}
