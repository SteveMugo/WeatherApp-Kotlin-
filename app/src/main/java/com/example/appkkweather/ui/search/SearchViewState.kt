package com.example.appkkweather.ui.search

import com.example.appkkweather.core.BaseViewState
import com.example.appkkweather.db.entity.CitiesForSearchEntity
import com.example.appkkweather.utils.domain.Status

class SearchViewState(
    val status: Status,
    val error: String? = null,
    val data: List<CitiesForSearchEntity>? = null
) : BaseViewState(status, error) {
    fun getSearchResult() = data
}
