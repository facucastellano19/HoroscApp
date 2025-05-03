package com.facudev.horoscapp.domain

import com.facudev.horoscapp.domain.model.PredictionModel


//En repository definimos todo lo que necesitamos de data
interface Repository {

    suspend fun getPrediction(signed: String):PredictionModel?
}