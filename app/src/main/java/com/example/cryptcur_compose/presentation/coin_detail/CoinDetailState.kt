package com.example.cryptcur_compose.presentation.coin_detail

import com.example.cryptcur_compose.domain.model.Coin
import com.example.cryptcur_compose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)