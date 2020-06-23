package com.ptit.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<T> (val creator: () -> T): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = creator() as T
}
