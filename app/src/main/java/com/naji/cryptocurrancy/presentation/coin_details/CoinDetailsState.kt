package com.naji.cryptocurrancy.presentation.coin_details

import com.naji.cryptocurrancy.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
