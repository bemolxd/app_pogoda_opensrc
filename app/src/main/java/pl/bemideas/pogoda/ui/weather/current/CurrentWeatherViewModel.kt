package pl.bemideas.pogoda.ui.weather.current

import androidx.lifecycle.ViewModel;
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.internal.UnitSystem
import pl.bemideas.pogoda.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC//get from settings

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered { forecastRepository.getCurrentWeather(isMetric) }
}
