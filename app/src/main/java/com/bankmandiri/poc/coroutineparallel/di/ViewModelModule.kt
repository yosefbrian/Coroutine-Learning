package com.bankmandiri.poc.coroutineparallel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bankmandiri.poc.coroutineparallel.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}