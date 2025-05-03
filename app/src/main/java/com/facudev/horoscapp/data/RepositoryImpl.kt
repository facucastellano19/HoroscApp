package com.facudev.horoscapp.data

import android.util.Log
import com.facudev.horoscapp.data.network.HoroscopeApiService
import com.facudev.horoscapp.domain.Repository
import com.facudev.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.math.sign

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Peticion retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() } //Recupero un modelo de tipo Response, y lo convierto a un modelo de la capa de dominio
            .onFailure { Log.i("facu","Ha ocurrido un error ${it.message}")  }
        return null
    }
}