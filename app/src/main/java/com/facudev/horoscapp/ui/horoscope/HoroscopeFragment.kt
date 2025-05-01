package com.facudev.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.facudev.horoscapp.databinding.FragmentHoroscopeBinding
import com.facudev.horoscapp.domain.model.HoroscopeInfo
import com.facudev.horoscapp.domain.model.HoroscopeInfo.*
import com.facudev.horoscapp.domain.model.HoroscopeModel
import com.facudev.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//Para que cualquier clase/fragment sea inyectable
@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //Conectamos nuestro fragment a nuestro viewModel
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    //Binding en los fragment
    private var _binding: FragmentHoroscopeBinding? = null

    //El var _binding original(que se puede modificar/romper) solo se puede llamar a traves de val binding
    private val binding get() = _binding!!

    //Para trabajar con metodos de configuracion
    //Y esto es cuando la vista ya esta creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            //it es HoroscopeInfo
            val type = when(it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type) //Este es el grafment de main_Graph
            )
        })

        binding.rvHoroscope.apply {
            //GridLayoutManager para dividir en columnas, en este caso 2
            binding.rvHoroscope.layoutManager = GridLayoutManager(context, 2)
            binding.rvHoroscope.adapter = horoscopeAdapter
        }

    }

    private fun initUIState() {
        //Esto crea una corrutina, que se engancha al ciclo de vida del fragment.
        //Si el fragment muere, la corutina tambien
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    //Siempre que haga un _horoscope.value(del viewModel), va a llamarse aca adentro ->
                    horoscopeAdapter.updateList(it)

                }
            }
        }
    }

    //Esto es cuando se crea la vista
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}
