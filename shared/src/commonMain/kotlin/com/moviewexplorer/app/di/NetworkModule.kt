package com.moviewexplorer.app.di

import com.moviewexplorer.app.config.TmdbConfig
import com.moviewexplorer.app.data.remote.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {

        single {

            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }

                install(Logging) {
                    level = LogLevel.ALL
                }

                defaultRequest {

                    url(NetworkConstants.BASE_URL)

                    header(
                        HttpHeaders.Authorization,
                        "Bearer ${TmdbConfig.API_TOKEN}"
                    )

                    header(
                        HttpHeaders.Accept,
                        "application/json"
                    )

                    contentType(ContentType.Application.Json)
                }
            }
        }
    }
