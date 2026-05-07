package br.com.fiap.dragonBallApp.domain.usecase

import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterDetail
import br.com.fiap.dragonBallApp.domain.model.CharacterFull
import br.com.fiap.dragonBallApp.domain.repository.CharacterRepository

class GetCharacterDetailByNumberUseCase(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(number: Int): Resource<CharacterFull> {
        if ( number <= 0){
            return Resource.Error("Informe um número maior que zero.")
        }
        if (number > 78){
            return Resource.Error("Informe um número válido até 78.")
        }
        return repository.getCharacterDetailByNumber(number)
    }
}