package br.com.fiap.dragonBallApp.data.repository

import br.com.fiap.dragonBallApp.data.model.toDomain
import br.com.fiap.dragonBallApp.data.remote.CharacterRemoteDataSource
import br.com.fiap.dragonBallApp.domain.common.Resource
import br.com.fiap.dragonBallApp.domain.model.CharacterDetail
import br.com.fiap.dragonBallApp.domain.model.CharacterFull
import br.com.fiap.dragonBallApp.domain.model.CharacterItem
import br.com.fiap.dragonBallApp.domain.model.Transformation
import br.com.fiap.dragonBallApp.domain.repository.CharacterRepository

class CharacterRepositoryImpl (
    private val remoteDataSource: CharacterRemoteDataSource
): CharacterRepository{
    override suspend fun getCharacterDetailByNumber(number: Int): Resource<CharacterFull> {
        return try {
            val responseDetail = remoteDataSource.getCharacterDetailByNumber(number)
            val responseTransformation = remoteDataSource.getTransformationsByNumber(number).map { it.toDomain() }


            val characterFull = CharacterFull(responseDetail.toDomain(), responseTransformation)
            Resource.Success(characterFull)
        } catch (exception: Exception){
            Resource.Error("Não foi possível buscar o personagem de id $number")
        }
    }

    override suspend fun getCharacters(): Resource<List<CharacterItem>> {
        return try {
            val response = remoteDataSource.getCharacters().map { it.toDomain() }
            Resource.Success(response)
        } catch (exception: Exception){
            Resource.Error("Falha ao capiturar pesonagens")
        }
    }

}