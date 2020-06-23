package com.ptit.ui.fragment.home

import com.ptit.base.BaseFragment
import com.ptit.data.api.ApiService
import com.ptit.data.api.RetrofitInstance
import com.ptit.data.repository.UserRepository
import com.ptit.data.source.remote.UserRemoteDataSource
import com.ptit.ui.R
import com.ptit.ui.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_home

    private val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)

    private val userRepository = UserRepository
        .getInstance(UserRemoteDataSource.getInstance(apiService))

    override fun onDetach() {
        super.onDetach()
    }

    override fun initData() {

    }

    override fun initViewModel() {

    }

    override fun observerData() {

    }

    override fun disposableObserver() {

    }
}
