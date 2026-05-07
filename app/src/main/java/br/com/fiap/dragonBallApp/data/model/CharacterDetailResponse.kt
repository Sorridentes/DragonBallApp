package br.com.fiap.dragonBallApp.data.model

import br.com.fiap.dragonBallApp.domain.model.CharacterDetail
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailResponse(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
)

fun CharacterDetailResponse.toDomain(): CharacterDetail{
    return CharacterDetail(
        id = id,
        name = name,
        image = image,
        description = description
    )
}