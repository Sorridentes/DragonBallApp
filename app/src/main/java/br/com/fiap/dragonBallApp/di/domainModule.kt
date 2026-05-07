package br.com.fiap.dragonBallApp.di

import br.com.fiap.dragonBallApp.domain.usecase.GetCharacterDetailByNumberUseCase
import br.com.fiap.dragonBallApp.domain.usecase.GetCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetCharacterDetailByNumberUseCase(repository = get())
    }

    factory{
        GetCharactersUseCase(repository = get())
    }
}