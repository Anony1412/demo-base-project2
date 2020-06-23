package com.ptit.di

import com.ptit.ui.fragment.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { SearchViewModel(get(named(KoinNames.USER_REPOSITORY))) }


}
