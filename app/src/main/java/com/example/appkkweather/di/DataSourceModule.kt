package com.example.appkkweather.di

import com.algolia.search.client.ClientPlaces
import com.example.appkkweather.db.dao.CitiesForSearchDao
import com.example.appkkweather.db.dao.CurrentWeatherDao
import com.example.appkkweather.db.dao.ForecastDao
import com.example.appkkweather.domain.WeatherAppAPI
import com.example.appkkweather.domain.datasource.currentWeather.CurrentWeatherLocalDataSource
import com.example.appkkweather.domain.datasource.currentWeather.CurrentWeatherRemoteDataSource
import com.example.appkkweather.domain.datasource.forecast.ForecastLocalDataSource
import com.example.appkkweather.domain.datasource.forecast.ForecastRemoteDataSource
import com.example.appkkweather.domain.datasource.searchCities.SearchCitiesLocalDataSource
import com.example.appkkweather.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRemoteDataSource(api: WeatherAppAPI) =
        CurrentWeatherRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideForecastRemoteDataSource(api: WeatherAppAPI) =
        ForecastRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideSearchCitiesRemoteDataSource(
        client: ClientPlaces,
        moshi: Moshi,
    ) = SearchCitiesRemoteDataSource(client, moshi)

    @Provides
    @Singleton
    fun provideCurrentWeatherLocalDataSource(currentWeatherDao: CurrentWeatherDao) =
        CurrentWeatherLocalDataSource(currentWeatherDao)

    @Provides
    @Singleton
    fun provideForecastLocalDataSource(forecastDao: ForecastDao) =
        ForecastLocalDataSource(forecastDao)

    @Provides
    @Singleton
    fun provideSearchCitiesLocalDataSource(citiesForSearchDao: CitiesForSearchDao) =
        SearchCitiesLocalDataSource(citiesForSearchDao)

}