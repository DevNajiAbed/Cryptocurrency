package com.naji.cryptocurrancy.domain.use_cases.get_coin

import com.naji.cryptocurrancy.common.Resource
import com.naji.cryptocurrancy.data.remote.dto.toCoin
import com.naji.cryptocurrancy.data.remote.dto.toCoinDetails
import com.naji.cryptocurrancy.domain.model.Coin
import com.naji.cryptocurrancy.domain.model.CoinDetails
import com.naji.cryptocurrancy.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            // HttpException: happens when the response code doesn't start with 2.
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            e.printStackTrace()
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
            e.printStackTrace()
        }
    }
}