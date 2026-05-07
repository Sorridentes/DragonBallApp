package br.com.fiap.dragonBallApp.domain.model

data class CharacterFull(
    val detail: CharacterDetail,
    val transformations: List<Transformation>
)