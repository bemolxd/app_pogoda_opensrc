package pl.bemideas.pogoda.ui.base

import androidx.lifecycle.ViewModel
import pl.bemideas.pogoda.data.provider.UnitProvider
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.internal.UnitSystem
import pl.bemideas.pogoda.internal.lazyDeffered

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeffered {
        forecastRepository.getWeatherLocation()
    }
}