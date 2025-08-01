package com.example.appkkweather.domain.datasource.searchCities

import androidx.lifecycle.LiveData
import com.example.appkkweather.db.dao.CitiesForSearchDao
import com.example.appkkweather.db.entity.CitiesForSearchEntity
import com.example.appkkweather.domain.model.SearchResponse
import javax.inject.Inject

class SearchCitiesLocalDataSource @Inject constructor(
    private val citiesForSearchDao: CitiesForSearchDao
) {

    fun getCityByName(cityName: String?): LiveData<List<CitiesForSearchEntity>> = citiesForSearchDao.getCityByName(
        cityName
    )

    fun insertCities(response: SearchResponse) {
        response.hits
            ?.map { CitiesForSearchEntity(it) }
            ?.let { citiesForSearchDao.insertCities(it) }
    }
}
