package com.siyu.doordashlite.dagger

import com.siyu.doordashlite.DoorDashLiteApplication
import com.siyu.doordashlite.network.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(doordashApp: DoorDashLiteApplication) {

    companion object {
        const val BASE_URI = "https://api.doordash.com/v2/"
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}