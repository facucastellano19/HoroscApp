package com.facudev.horoscapp.ui.detail

import com.facudev.horoscapp.domain.model.HoroscopeModel


//Porque una pantalla de estados? Porque nuestras pantallas va a trabajar gestionando estados
// Si le paso un estado ERROR, LOADING, ACCESS, la vista la ya a saber que hacer

//Cuando hay que pasarle parametros es una data class
//Cuando no lo requiere como un object es data object
sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}