package pl.bemideas.pogoda

import android.app.Application
import android.content.Context
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import pl.bemideas.pogoda.data.db.ForecastDatabase
import pl.bemideas.pogoda.data.network.*
import pl.bemideas.pogoda.data.provider.LocationProvider
import pl.bemideas.pogoda.data.provider.LocationProviderImpl
import pl.bemideas.pogoda.data.provider.UnitProvider
import pl.bemideas.pogoda.data.provider.UnitProviderImpl
import pl.bemideas.pogoda.data.repository.ForecastRepository
import pl.bemideas.pogoda.data.repository.ForecastRepositoryImpl
import pl.bemideas.pogoda.ui.weather.current.CurrentWeatherViewModelFactory

class ForecastApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton {ForecastDatabase(instance())}
        bind() from singleton {instance<ForecastDatabase>().currentWeatherDao()}
        bind() from singleton {instance<ForecastDatabase>().weatherLocationDao()}
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton {ApixuWeatherApiService(instance())}
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}