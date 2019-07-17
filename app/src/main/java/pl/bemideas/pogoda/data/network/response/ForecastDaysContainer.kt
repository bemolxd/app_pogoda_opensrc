package pl.bemideas.pogoda.data.network.response


import com.google.gson.annotations.SerializedName
import pl.bemideas.pogoda.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)