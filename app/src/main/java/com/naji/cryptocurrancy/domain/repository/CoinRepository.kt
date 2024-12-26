package com.naji.cryptocurrancy.domain.repository

import com.naji.cryptocurrancy.data.remote.dto.CoinDetailsDto
import com.naji.cryptocurrancy.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto
}