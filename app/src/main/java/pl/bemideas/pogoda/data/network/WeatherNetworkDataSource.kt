package pl.bemideas.pogoda.data.network

import androidx.lifecycle.LiveData
import pl.bemideas.pogoda.data.network.response.CurrentWeatherResponse
import pl.bemideas.pogoda.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}