package br.com.fiap.dragonBallApp.di

import br.com.fiap.dragonBallApp.presentation.character.detail.CharacterDetailViewModel
import br.com.fiap.dragonBallApp.presentation.character.list.CharacterListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::CharacterDetailViewModel)
    viewModelOf(::CharacterListViewModel)
}