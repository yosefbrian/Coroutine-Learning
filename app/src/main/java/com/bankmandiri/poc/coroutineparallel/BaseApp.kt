package com.bankmandiri.poc.coroutineparallel

import android.app.Application
import com.bankmandiri.poc.coroutineparallel.di.DaggerAppComponent

class BaseApp: Application() {
    val appComponent = DaggerAppComponent.create()
}