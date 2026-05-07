package br.com.fiap.dragonBallApp.domain.usecase

import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterItem
import br.com.fiap.dragonBallApp.domain.repository.CharacterRepository

class GetCharactersUseCase(
    private val repository: CharacterRepository
){
    suspend operator fun invoke(): Resource<List<CharacterItem>>{
        return repository.getCharacters()
    }
}