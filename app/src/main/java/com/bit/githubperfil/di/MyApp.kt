package com.bit.githubperfil.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

/**
 * @Author:  Vitor Rey
 * @Date: 28,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(networkModule, viewmodelModule, repositoryModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}