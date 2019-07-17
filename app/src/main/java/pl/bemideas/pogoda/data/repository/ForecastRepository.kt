package pl.bemideas.pogoda.data.repository

import androidx.lifecycle.LiveData
import org.threeten.bp.LocalDate
import pl.bemideas.pogoda.data.db.entity.WeatherLocation
import pl.bemideas.pogoda.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import pl.bemideas.pogoda.data.db.unitlocalized.future.UnitSpecificSimpleFutureWeatherEntry

interface ForecastRepository{
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>

    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}