package com.siyu.doordashlite.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.siyu.doordashlite.DoorDashLiteApplication
import com.siyu.doordashlite.network.ApiInterface
import com.siyu.doordashlite.entity.Restaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal
import javax.inject.Inject

class RestaurantsRepository(application: Application) {
    companion object {
        const val TAG = "RestaurantsRepository"
        const val testLat = 37.422740
        const val testLng = -122.139956
        const val testOffset = 0
        const val testLimit = 50
    }

    @Inject
    lateinit var restaurantsInterface: ApiInterface
    val restaurantsLiveData: MutableLiveData<List<Restaurant>> = MutableLiveData();

    init {
        (application as DoorDashLiteApplication).getDagger().inject(this)
    }

    fun getGifData(): MutableLiveData<List<Restaurant>> {
        restaurantsInterface.getNearbyRestaurants(testLat, testLng, testOffset, testLimit).enqueue(object: Callback<List<Restaurant>> {
            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.e(TAG, "Error in get restaurant ${t.message}")
            }

            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "Fetching restaurant unsuccessful: $response.message()")
                    return
                }
                restaurantsLiveData.value = response.body()
            }
        })
        return restaurantsLiveData
    }
}