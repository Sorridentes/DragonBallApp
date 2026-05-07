package br.com.fiap.dragonBallApp.data.remote

import br.com.fiap.dragonBallApp.data.model.CharacterDetailResponse
import br.com.fiap.dragonBallApp.data.model.CharacterItemResponse
import br.com.fiap.dragonBallApp.data.model.TransformationResponse

class CharacterRemoteDataSourceImpl(
    private val api: CharacterApi
) : CharacterRemoteDataSource {
    override suspend fun getCharacterDetailByNumber(number: Int): CharacterDetailResponse {
        return api.getCharacterDetailByNumber(number)
    }

    override suspend fun getCharacters(): List<CharacterItemResponse> {
        return api.getCharacters()
    }

    override suspend fun getTransformationsByNumber(number: Int): List<TransformationResponse> {
        return api.getTransformations(number)
    }
}