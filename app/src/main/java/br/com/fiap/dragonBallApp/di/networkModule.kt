package br.com.fiap.dragonBallApp.di

import br.com.fiap.dragonBallApp.data.remote.CharacterApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Json{
            ignoreUnknownKeys = true
        }
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://dragon-ball-api-055bab372b94.herokuapp.com/api/")
            .client(get())
            .addConverterFactory(
                get<Json>().asConverterFactory(
                    "application/json".toMediaType()
                )
            )
            .build()
    }

    single<CharacterApi> {
        get<Retrofit>().create(CharacterApi::class.java)
    }
}