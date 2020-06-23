package com.ptit.ui.activity.main

import com.ptit.base.BaseActivity
import com.ptit.ui.R
import com.ptit.ui.fragment.search.SearchFragment

class MainActivity : BaseActivity() {

    override val layoutRes get() = R.layout.activity_main

    override fun initView() {
        setFragment(R.id.frameContent, SearchFragment.newInstance())
    }

    override fun initData() {
    }

    override fun initViewModel() {
    }

    override fun observerData() {
    }
}
