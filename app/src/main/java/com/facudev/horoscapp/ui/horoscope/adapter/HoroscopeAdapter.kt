package com.facudev.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facudev.horoscapp.R
import com.facudev.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo)->Unit) :  //Funcion LAMBDA para sabes cual es el item pulsado
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {

        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_horoscope,
                parent,
                false
            ) //Que vamos a pintar? lo que tenemos aca
        )
    }

    override fun getItemCount() = horoscopeList.size

    // Este metodo se encarga de decirle al viewHolder lo que tiene que pintar
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }

}