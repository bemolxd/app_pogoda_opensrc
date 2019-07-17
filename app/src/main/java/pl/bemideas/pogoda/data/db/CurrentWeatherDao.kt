package pl.bemideas.pogoda.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.bemideas.pogoda.data.db.entity.CURRENT_WEATHER_ID
import pl.bemideas.pogoda.data.db.entity.CurrentWeatherEntry
import pl.bemideas.pogoda.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import pl.bemideas.pogoda.data.db.unitlocalized.current.MetricCurrentWeatherEntry


@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}