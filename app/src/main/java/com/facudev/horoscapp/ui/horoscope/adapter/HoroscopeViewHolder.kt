package com.facudev.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.facudev.horoscapp.databinding.ItemHoroscopeBinding
import com.facudev.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context=binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        // Cuando pulse algo en la celda va a ejecutar{}
        //Esto lo usamos en el fragment. InitRecyclerview

        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, newLambda = { onItemSelected(horoscopeInfo)}) //2) Va a llamar otra funcion LAMBDA
            //onItemSelected(horoscopeInfo)
        }

    }

    private fun startRotationAnimation(view:View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500 //En milisegundos
            interpolator = LinearInterpolator() //define el camino de la animacion. Misma velocidad en todo momento
            rotationBy(360f) //Rota sobre su propio punto. en 360 una vuelta entera
            withEndAction { newLambda() } //1) Cuando se ejecute este funcion LAMBDA
            start()
        }
    }
}