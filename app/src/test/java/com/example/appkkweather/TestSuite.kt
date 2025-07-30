package com.example.appkkweather

import android.os.Build
import com.example.appkkweather.dao.CitiesForSearchDaoTest
import com.example.appkkweather.dao.CurrentWeatherDaoTest
import com.example.appkkweather.dao.ForecastDaoTest
import com.example.appkkweather.repo.CurrentWeatherRepositoryTest
import com.example.appkkweather.repo.ForecastRepositoryTest
import com.example.appkkweather.viewModel.DashboardViewModelTest
import com.example.appkkweather.viewModel.SearchViewModelTest
import com.example.appkkweather.viewModel.WeatherDetailViewModelTest
import com.example.appkkweather.viewState.CurrentWeatherViewStateTest
import com.example.appkkweather.viewState.ForecastViewStateTest
import com.example.appkkweather.viewState.SearchViewStateTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.R])
@RunWith(Suite::class)
@Suite.SuiteClasses(
    CitiesForSearchDaoTest::class,
    CurrentWeatherDaoTest::class,
    CurrentWeatherViewStateTest::class,
    DashboardViewModelTest::class,
    ForecastDaoTest::class,
    ForecastViewStateTest::class,
    SearchViewStateTest::class,
    SearchViewModelTest::class,
    WeatherDetailViewModelTest::class,
    ForecastRepositoryTest::class,
    CurrentWeatherRepositoryTest::class
)
class TestSuite
