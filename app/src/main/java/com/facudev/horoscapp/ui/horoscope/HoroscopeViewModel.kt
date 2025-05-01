package com.facudev.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.facudev.horoscapp.data.providers.HoroscopeProvider
import com.facudev.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import com.facudev.horoscapp.domain.model.HoroscopeInfo.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

//ViewModel preparado para usarlo con daggerhilt
@HiltViewModel

// Como inyectar datos? con @Inject..

//Nos permite que adentro del constructor inyectemos lo que queramos x ej constructor(pepe:Pepe)

// Extendemos de ViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel() {

    //Esto se tiene que comunicar con la vista (Fragment)
    //Esta lista es mutable. Pero yo no quiero que fuera del viewModel puedan modificarla
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    //Entonces creamos  algo que no es mutable "val" y le asigno el de arriba.
    //Es decir que con esta linea solo va a poder leer la private var _horoscope, sin modificar
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope


    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }


}