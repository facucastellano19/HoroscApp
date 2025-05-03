package com.facudev.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager):Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        //La peticion que va a llegar al servidor la agarramos..
        val request = chain
            .request()
            .newBuilder()//Volvete a crear pero con algo nuevo que te voy a meter :
            .header("Autorization", tokenManager.getToken())
            .build()
        return chain.proceed(request)
    }
}

class TokenManager @Inject constructor(){
    fun getToken():String = "SUSCRIBE"
}