package br.com.fiap.dragonBallApp.domain.repository

import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterFull
import br.com.fiap.dragonBallApp.domain.model.CharacterItem

interface CharacterRepository {
    suspend fun getCharacterDetailByNumber(number: Int): Resource<CharacterFull>
    suspend fun getCharacters(): Resource<List<CharacterItem>>
}