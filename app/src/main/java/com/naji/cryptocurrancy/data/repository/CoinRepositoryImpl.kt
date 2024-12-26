package com.naji.cryptocurrancy.data.repository

import com.naji.cryptocurrancy.data.remote.CoinPaprikaApi
import com.naji.cryptocurrancy.data.remote.dto.CoinDetailsDto
import com.naji.cryptocurrancy.data.remote.dto.CoinDto
import com.naji.cryptocurrancy.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}