package com.delight.labs.games.di
import org.koin.dsl.module.module
import com.delight.labs.games.view.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel

val viewModelModule = module {

    viewModel { MainViewModel() }

}

val appModule = listOf(viewModelModule)