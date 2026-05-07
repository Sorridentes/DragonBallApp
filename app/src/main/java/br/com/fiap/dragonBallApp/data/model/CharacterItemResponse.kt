package br.com.fiap.dragonBallApp.data.model

import br.com.fiap.dragonBallApp.domain.model.CharacterItem
import kotlinx.serialization.Serializable

@Serializable
data class CharacterItemResponse(
    val id: Int,
    val name: String,
    val image: String
)

fun CharacterItemResponse.toDomain(): CharacterItem{
    return CharacterItem(
        id= id,
        name = name.replaceFirstChar { it.uppercase() },
        image = image
    )
}