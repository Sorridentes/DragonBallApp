package br.com.fiap.dragonBallApp.presentation.navigation

object AppRoutes {
    const val CHARACTER_LIST = "character_list"
    const val CHARACTER_DETAIL = "character_detail/{characterNumber}"

    fun characterDetail(characterNumber: Int): String{
        return "character_detail/$characterNumber"
    }
}