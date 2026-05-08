package br.com.fiap.dragonBallApp.data.model

import br.com.fiap.dragonBallApp.domain.model.Transformation
import kotlinx.serialization.Serializable

@Serializable
data class TransformationResponse (
    val id: Int,
    val name: String,
    val image: String
)

fun TransformationResponse.toDomain(): Transformation{
    return Transformation(
        id, name, image
    )
}