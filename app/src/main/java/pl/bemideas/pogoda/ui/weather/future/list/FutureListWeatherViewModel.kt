package pl.bemideas.pogoda.ui.weather.future.list

import org.threeten.bp.LocalDate
import pl.bemideas.pogoda.data.provider.UnitProvider
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.internal.lazyDeffered
import pl.bemideas.pogoda.ui.base.WeatherViewModel

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeffered {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}