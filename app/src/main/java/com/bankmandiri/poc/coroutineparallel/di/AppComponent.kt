package com.bankmandiri.poc.coroutineparallel.di

import com.bankmandiri.poc.coroutineparallel.ui.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
}