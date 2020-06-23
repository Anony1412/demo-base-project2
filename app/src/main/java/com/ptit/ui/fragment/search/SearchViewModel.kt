package com.ptit.ui.fragment.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ptit.base.BaseViewModel
import com.ptit.data.repository.UserRepository
import com.ptit.data.source.remote.response.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private val userRepository: UserRepository) : BaseViewModel() {

    val disposable = CompositeDisposable()

    val userResponse: LiveData<UserResponse> get() = _userResponse
    private val _userResponse = MutableLiveData<UserResponse>()

    fun findUserByUsername(username: String) {
        userRepository.findUserByUsername(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _userResponse.value = it },
                { messageErrorLiveData.value = it.message }
            ).addTo(disposable)
    }
}
