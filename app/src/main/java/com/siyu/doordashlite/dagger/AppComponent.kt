package com.siyu.doordashlite.dagger

import com.siyu.doordashlite.repository.RestaurantsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(gifList: RestaurantsRepository)
}