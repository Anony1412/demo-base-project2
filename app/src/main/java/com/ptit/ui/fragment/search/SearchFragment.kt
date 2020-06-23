package com.ptit.ui.fragment.search

import androidx.lifecycle.Observer
import com.ptit.base.BaseFragment
import com.ptit.data.source.remote.response.UserResponse
import com.ptit.ui.R
import com.ptit.ui.databinding.FragmentSearchBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_search

    private val searchViewModel: SearchViewModel by viewModel()

    override fun initData() {
    }

    override fun initViewModel() {

        searchViewModel.findUserByUsername("hello")
    }

    override fun observerData() {
        searchViewModel.userResponse.observe(this, Observer { showUser(it) })
    }

    override fun disposableObserver() {
        searchViewModel.disposable.clear()
    }

    private fun showUser(userResponse: UserResponse) {
        println(userResponse.toString())
        viewDataBinding?.user = userResponse.user
    }

    companion object {

        fun newInstance() = SearchFragment()
    }
}
