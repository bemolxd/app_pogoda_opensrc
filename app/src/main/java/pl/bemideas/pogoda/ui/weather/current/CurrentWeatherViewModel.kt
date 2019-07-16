package pl.bemideas.pogoda.ui.weather.current

import androidx.lifecycle.ViewModel;
import pl.bemideas.pogoda.data.provider.UnitProvider
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.internal.UnitSystem
import pl.bemideas.pogoda.internal.lazyDeffered

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository, unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeffered { forecastRepository.getCurrentWeather(isMetric) }
}
