package com.ptit.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    protected var viewDataBinding: VB? = null

    @get: LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = performDataBinding(container)
        return viewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initViewModel()
        observerData()
    }

    override fun onDetach() {
        super.onDetach()
        disposableObserver()
    }

    abstract fun initData()

    abstract fun initViewModel()

    abstract fun observerData()

    abstract fun disposableObserver()

    private fun performDataBinding(container: ViewGroup?): VB? =
        DataBindingUtil.inflate(
            LayoutInflater.from(activity),
            layoutRes,
            container,
            false
        )
}
