package pl.bemideas.pogoda.data.repository

import androidx.lifecycle.LiveData
import pl.bemideas.pogoda.data.db.entity.WeatherLocation
import pl.bemideas.pogoda.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository{
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}