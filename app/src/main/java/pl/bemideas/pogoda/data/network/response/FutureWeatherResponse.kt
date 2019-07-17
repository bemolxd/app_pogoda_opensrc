package pl.bemideas.pogoda.data.network.response



import com.google.gson.annotations.SerializedName
import pl.bemideas.pogoda.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)