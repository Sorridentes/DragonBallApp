package br.com.fiap.dragonBallApp.di

import br.com.fiap.dragonBallApp.data.remote.CharacterRemoteDataSource
import br.com.fiap.dragonBallApp.data.remote.CharacterRemoteDataSourceImpl
import br.com.fiap.dragonBallApp.data.repository.CharacterRepositoryImpl
import br.com.fiap.dragonBallApp.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single<CharacterRemoteDataSource> {
        CharacterRemoteDataSourceImpl(api = get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(remoteDataSource = get())
    }
}