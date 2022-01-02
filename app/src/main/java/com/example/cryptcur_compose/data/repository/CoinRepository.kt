package com.example.cryptcur_compose.data.repository

import com.example.cryptcur_compose.data.remote.dto.CoinDetailDto
import com.example.cryptcur_compose.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto

}