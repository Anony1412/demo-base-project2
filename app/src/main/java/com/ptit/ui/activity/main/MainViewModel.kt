package com.ptit.ui.activity.main

import androidx.lifecycle.MutableLiveData
import com.ptit.base.BaseViewModel
import com.ptit.data.repository.UserRepository
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MainViewModel (private val userRepository: UserRepository): BaseViewModel() {

    val disposable = CompositeDisposable()
}
