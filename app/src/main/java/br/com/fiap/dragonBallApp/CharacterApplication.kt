package br.com.fiap.dragonBallApp

import android.app.Application
import br.com.fiap.dragonBallApp.di.dataModule
import br.com.fiap.dragonBallApp.di.domainModule
import br.com.fiap.dragonBallApp.di.networkModule
import br.com.fiap.dragonBallApp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CharacterApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CharacterApplication)

            modules(
                networkModule,
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}