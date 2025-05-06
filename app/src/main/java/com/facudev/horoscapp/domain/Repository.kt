package com.facudev.horoscapp.domain

import com.facudev.horoscapp.domain.model.PredictionModel



interface Repository {

    suspend fun getPrediction(signed: String):PredictionModel?
}