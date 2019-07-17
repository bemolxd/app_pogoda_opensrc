package pl.bemideas.pogoda.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import org.threeten.bp.LocalDate
import pl.bemideas.pogoda.data.db.entity.FutureWeatherEntry
import pl.bemideas.pogoda.data.db.unitlocalized.future.ImperialSimpleFutureWeatherEntry
import pl.bemideas.pogoda.data.db.unitlocalized.future.MetricSimpleFutureWeatherEntry

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(futureWeatherEntries: List<FutureWeatherEntry>)

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from future_weather where date(date) >= date(:startDate)")
    fun getSimpleWeatherForecastsMetric(startDate: LocalDate): LiveData<List<MetricSimpleFutureWeatherEntry>>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from future_weather where date(date) >= date(:startDate)")
    fun getSimpleWeatherForecastsImperial(startDate: LocalDate): LiveData<List<ImperialSimpleFutureWeatherEntry>>

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select count(id) from future_weather where date(date) >= date(:startDate)")
    fun countFutureWeather(startDate: LocalDate): Int

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("delete from future_weather where date(date) < date(:firstDateToKeep)")
    fun deleteOldEntries(firstDateToKeep: LocalDate)
}