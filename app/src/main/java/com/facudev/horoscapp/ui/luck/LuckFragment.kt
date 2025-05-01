package com.facudev.horoscapp.ui.luck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facudev.horoscapp.R
import com.facudev.horoscapp.databinding.FragmentHoroscopeBinding
import com.facudev.horoscapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckFragment : Fragment() {

    //Binding en los fragment
    private var _binding: FragmentLuckBinding? = null

    //El var _binding original(que se puede modificar/romper) solo se puede llamar a traves de val binding
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}