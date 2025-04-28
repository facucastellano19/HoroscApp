package com.facudev.horoscapp.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facudev.horoscapp.databinding.FragmentHoroscopeBinding

class HoroscopeFragment : Fragment() {

    //Binding en los fragment
    private var _binding: FragmentHoroscopeBinding? = null

    //El var _binding original(que se puede modificar/romper) solo se puede llamar a traves de val binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
