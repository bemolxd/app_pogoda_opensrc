package pl.bemideas.pogoda.data.network

import androidx.lifecycle.LiveData
import pl.bemideas.pogoda.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}