package com.facudev.horoscapp.data.network

import com.facudev.horoscapp.BuildConfig.BASE_URL
import com.facudev.horoscapp.data.RepositoryImpl
import com.facudev.horoscapp.data.core.interceptors.AuthInterceptor
import com.facudev.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //MODULO
object NetworkModule {

    //Esto nos permite inyectar el objeto retrofit donde queramos
    @Provides
    @Singleton //Patron de diseño, una unica instancia de cada clase, para que no se cree infinitas veces el retrofit
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()

    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    //Cuando alguien llame a este repositorio, va a devolver un apiService y se pasa a RepositoryImpl
    @Provides
    fun providesRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }
}