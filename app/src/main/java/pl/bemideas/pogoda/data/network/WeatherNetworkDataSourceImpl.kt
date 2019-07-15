package pl.bemideas.pogoda.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.bemideas.pogoda.data.network.response.CurrentWeatherResponse
import pl.bemideas.pogoda.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location, languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Cpnnectivity", "No Internet connection.", e)
        }
    }
}