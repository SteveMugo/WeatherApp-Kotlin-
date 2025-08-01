package com.example.appkkweather.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.appkkweather.core.Constants
import com.example.appkkweather.db.entity.ForecastEntity
import com.example.appkkweather.repo.ForecastRepository
import com.example.appkkweather.ui.dashboard.ForecastMapper
import com.example.appkkweather.ui.dashboard.ForecastViewState
import com.example.appkkweather.utils.UseCaseLiveData
import com.example.appkkweather.utils.domain.Resource
import javax.inject.Inject

class ForecastUseCase @Inject internal constructor(private val repository: ForecastRepository) : UseCaseLiveData<ForecastViewState, ForecastUseCase.ForecastParams, ForecastRepository>() {

    override fun getRepository(): ForecastRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: ForecastParams?): LiveData<ForecastViewState> {
        return repository.loadForecastByCoord(
            params?.lat?.toDouble() ?: 0.0,
            params?.lon?.toDouble() ?: 0.0,
            params?.fetchRequired
                ?: false,
            units = params?.units ?: Constants.Coords.METRIC
        ).map {
            onForecastResultReady(it)
        }
    }

    private fun onForecastResultReady(resource: Resource<ForecastEntity>): ForecastViewState {
        val mappedList = resource.data?.list?.let { ForecastMapper().mapFrom(it) }
        resource.data?.list = mappedList

        return ForecastViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class ForecastParams(
        val lat: String = "",
        val lon: String = "",
        val fetchRequired: Boolean,
        val units: String
    ) : Params()
}
