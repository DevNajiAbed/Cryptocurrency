package com.naji.cryptocurrancy.domain.use_cases.get_coins

import com.naji.cryptocurrancy.common.Resource
import com.naji.cryptocurrancy.data.remote.dto.toCoin
import com.naji.cryptocurrancy.domain.model.Coin
import com.naji.cryptocurrancy.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
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