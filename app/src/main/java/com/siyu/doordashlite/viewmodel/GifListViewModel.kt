package com.siyu.doordashlite.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.siyu.doordashlite.entity.Restaurant
import com.siyu.doordashlite.repository.RestaurantsRepository

class GifListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RestaurantsRepository = RestaurantsRepository(application)
    val restaurantsLiveData: MutableLiveData<List<Restaurant>>
        get() = repository.getGifData()
}
