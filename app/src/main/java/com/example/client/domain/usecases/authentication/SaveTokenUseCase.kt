package com.example.client.domain.usecases.authentication

import com.example.client.data.remote.security.Token
import com.example.client.data.repositories.DataStoreRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
) {
    suspend fun invoke (token : Token) {
        dataStoreRepository.saveAccessToken(token.access)
        dataStoreRepository.saveRefreshToken(token.refresh)
    }
}