package com.facudev.horoscapp.motherobject

import com.facudev.horoscapp.data.network.response.PredictionResponse
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Aries
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Leo
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Libra
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.facudev.horoscapp.domain.model.HoroscopeInfo.Virgo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction","taurus")

    val horoscopeInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}