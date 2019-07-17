package pl.bemideas.pogoda.ui.weather.current

import androidx.lifecycle.ViewModel;
import pl.bemideas.pogoda.data.provider.UnitProvider
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.internal.UnitSystem
import pl.bemideas.pogoda.internal.lazyDeffered
import pl.bemideas.pogoda.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository, unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {


    val weather by lazyDeffered { forecastRepository.getCurrentWeather(super.isMetricUnit) }

}
