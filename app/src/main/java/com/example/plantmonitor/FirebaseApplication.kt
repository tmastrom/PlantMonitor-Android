package com.example.plantmonitor

import android.app.Application
import com.example.plantmonitor.data.firebase.FirebaseSource
import com.example.plantmonitor.ui.dashboard.DashboardViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class FirebaseApplication : Application(), KodeinAware{

    override val kodein = Kodein.lazy {
        import(androidXModule(this@FirebaseApplication))

        bind() from singleton { FirebaseSource() }
        bind() from provider { DashboardViewModelFactory() }
    }
}