package br.com.fiap.dragonBallApp.data.remote

import br.com.fiap.dragonBallApp.data.model.CharacterDetailResponse
import br.com.fiap.dragonBallApp.data.model.CharacterItemResponse
import br.com.fiap.dragonBallApp.data.model.TransformationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("characters/{id}")
    suspend fun getCharacterDetailByNumber(
        @Path("id") number: Int
    ): CharacterDetailResponse

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int = 78,
        @Query("offset") offset: Int = 0
    ): List<CharacterItemResponse>

    @GET("characters/{id}/transformations")
    suspend fun getTransformations(
        @Path("id") number: Int
    ): List<TransformationResponse>
}
