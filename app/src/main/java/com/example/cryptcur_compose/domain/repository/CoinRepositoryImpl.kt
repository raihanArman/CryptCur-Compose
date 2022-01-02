package com.example.cryptcur_compose.domain.repository

import com.example.cryptcur_compose.data.remote.CoinPaprikaApi
import com.example.cryptcur_compose.data.remote.dto.CoinDetailDto
import com.example.cryptcur_compose.data.remote.dto.CoinDto
import com.example.cryptcur_compose.data.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}