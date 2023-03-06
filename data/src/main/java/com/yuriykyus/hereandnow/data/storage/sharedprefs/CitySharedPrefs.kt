package com.yuriykyus.hereandnow.data.storage.sharedprefs

import android.content.Context
import com.yuriykyus.hereandnow.data.Utils
import com.yuriykyus.hereandnow.data.storage.CityStorage
import com.yuriykyus.hereandnow.data.storage.models.City
import com.yuriykyus.hereandnow.domain.models.CityName
import com.yuriykyus.hereandnow.domain.models.CityPhoto

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "nameKey"
private const val DEFAULT_CITY_NAME = "Default city name"

class CitySharedPrefs(context: Context) : CityStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getName(): City {
        val city: String = Utils.getCity()
//        val city = sharedPreferences.getString(KEY_NAME, DEFAULT_CITY_NAME) ?: DEFAULT_CITY_NAME
        return City(city)
    }

    override fun saveName(city: City): Boolean {
        sharedPreferences.edit().putString(KEY_NAME, city.cityName).apply()
        return true
    }

    override fun getPhoto(cityName: CityName): CityPhoto {
        return CityPhoto(photoUrl = "https://live.staticflickr.com/65535/52706675986_d0b86a7021_b.jpg")
    }
}