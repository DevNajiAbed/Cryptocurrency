package com.naji.cryptocurrancy.presentation.coin_list

import com.naji.cryptocurrancy.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
