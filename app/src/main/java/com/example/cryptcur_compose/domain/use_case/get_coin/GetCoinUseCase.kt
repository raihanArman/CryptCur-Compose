package com.example.cryptcur_compose.domain.use_case.get_coin

import com.example.cryptcur_compose.common.Resource
import com.example.cryptcur_compose.data.remote.dto.toCoin
import com.example.cryptcur_compose.data.remote.dto.toCoinDetail
import com.example.cryptcur_compose.data.repository.CoinRepository
import com.example.cryptcur_compose.domain.model.Coin
import com.example.cryptcur_compose.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coidId: String): Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading())
            val coin = repository.getCoinById(coidId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexcepted error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connect"))
        }
    }

}