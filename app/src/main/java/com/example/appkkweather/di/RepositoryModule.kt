package com.example.appkkweather.di

import com.example.appkkweather.domain.datasource.currentWeather.CurrentWeatherLocalDataSource
import com.example.appkkweather.domain.datasource.currentWeather.CurrentWeatherRemoteDataSource
import com.example.appkkweather.domain.datasource.forecast.ForecastLocalDataSource
import com.example.appkkweather.domain.datasource.forecast.ForecastRemoteDataSource
import com.example.appkkweather.domain.datasource.searchCities.SearchCitiesLocalDataSource
import com.example.appkkweather.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.example.appkkweather.repo.CurrentWeatherRepository
import com.example.appkkweather.repo.ForecastRepository
import com.example.appkkweather.repo.SearchCitiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherRepository(
        currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource,
        currentWeatherLocalDataSource: CurrentWeatherLocalDataSource,
    ) = CurrentWeatherRepository(currentWeatherRemoteDataSource, currentWeatherLocalDataSource)

    @Provides
    @Singleton
    fun provideForecastRepository(
        forecastRemoteDataSource: ForecastRemoteDataSource,
        forecastLocalDataSource: ForecastLocalDataSource,
    ) = ForecastRepository(forecastRemoteDataSource, forecastLocalDataSource)

    @Provides
    @Singleton
    fun provideSearchCitiesRepository(
        searchCitiesRemoteDataSource: SearchCitiesRemoteDataSource,
        searchCitiesLocalDataSource: SearchCitiesLocalDataSource,
    ) = SearchCitiesRepository(searchCitiesRemoteDataSource, searchCitiesLocalDataSource)

}