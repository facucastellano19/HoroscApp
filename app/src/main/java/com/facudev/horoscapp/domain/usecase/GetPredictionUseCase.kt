package com.facudev.horoscapp.domain.usecase

import com.facudev.horoscapp.domain.Repository
import javax.inject.Inject


//Desde dominio solo vamos a pedir un repositorio. Y DaggerHilt se encarga de darme lo que pido
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}