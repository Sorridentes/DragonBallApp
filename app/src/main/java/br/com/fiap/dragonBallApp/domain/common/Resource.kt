package br.com.fiap.dragonBallApp.domain.common

import org.koin.core.logger.MESSAGE

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}