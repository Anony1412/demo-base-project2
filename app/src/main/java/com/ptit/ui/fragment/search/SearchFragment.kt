package com.ptit.ui.fragment.search

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ptit.base.BaseFragment
import com.ptit.base.ViewModelFactory
import com.ptit.data.api.ApiService
import com.ptit.data.api.RetrofitInstance
import com.ptit.data.repository.UserRepository
import com.ptit.data.source.remote.UserRemoteDataSource
import com.ptit.data.source.remote.response.UserResponse
import com.ptit.ui.R
import com.ptit.ui.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_search

    private val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)

    private val userRepository = UserRepository
        .getInstance(UserRemoteDataSource.getInstance(apiService))

    private var searchViewModel: SearchViewModel? = null

    override fun initData() {
    }

    override fun initViewModel() {
        searchViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory { SearchViewModel(userRepository) }
        ).get(SearchViewModel::class.java)

        searchViewModel?.findUserByUsername("hello")
    }

    override fun observerData() {
        searchViewModel?.userResponse?.observe(this, Observer { showUser(it) })
    }

    override fun disposableObserver() {
        searchViewModel?.disposable?.clear()
    }

    private fun showUser(userResponse: UserResponse) {
        println(userResponse.toString())
        viewDataBinding?.user = userResponse.user
    }

    companion object {

        fun newInstance() = SearchFragment()
    }
}
