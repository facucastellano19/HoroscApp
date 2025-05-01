package com.facudev.horoscapp.ui.luck

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//ViewModel preparado para usarlo con daggerhilt
@HiltViewModel

// Como inyectar datos? con @Inject..

//Nos permite que adentro del constructor inyectemos lo que queramos x ej constructor(pepe:Pepe)

// Extendemos de ViewModel
class LuckViewModel @Inject constructor():ViewModel() {
}