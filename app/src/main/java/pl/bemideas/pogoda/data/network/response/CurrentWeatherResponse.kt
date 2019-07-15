package pl.bemideas.pogoda.data.network.response

import com.google.gson.annotations.SerializedName
import pl.bemideas.pogoda.data.db.entity.CurrentWeatherEntry
import pl.bemideas.pogoda.data.db.entity.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)