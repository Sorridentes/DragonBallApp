package br.com.fiap.dragonBallApp.data.remote

import br.com.fiap.dragonBallApp.data.model.CharacterDetailResponse
import br.com.fiap.dragonBallApp.data.model.CharacterItemResponse
import br.com.fiap.dragonBallApp.data.model.TransformationResponse

interface CharacterRemoteDataSource {
    suspend fun getCharacterDetailByNumber(number: Int): CharacterDetailResponse
    suspend fun getCharacters(): List<CharacterItemResponse>
    suspend fun getTransformationsByNumber(number: Int): List<TransformationResponse>
}