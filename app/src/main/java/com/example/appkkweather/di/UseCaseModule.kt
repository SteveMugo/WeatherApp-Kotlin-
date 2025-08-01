package com.example.appkkweather.di

import com.example.appkkweather.domain.usecase.CurrentWeatherUseCase
import com.example.appkkweather.domain.usecase.ForecastUseCase
import com.example.appkkweather.domain.usecase.SearchCitiesUseCase
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
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCurrentWeatherUseCase(currentWeatherRepository: CurrentWeatherRepository) =
        CurrentWeatherUseCase(currentWeatherRepository)

    @Provides
    @Singleton
    fun provideForecastUseCase(forecastRepository: ForecastRepository) =
        ForecastUseCase(forecastRepository)

    @Provides
    @Singleton
    fun provideSearchCitiesUseCase(searchCitiesRepository: SearchCitiesRepository) =
        SearchCitiesUseCase(searchCitiesRepository)

}