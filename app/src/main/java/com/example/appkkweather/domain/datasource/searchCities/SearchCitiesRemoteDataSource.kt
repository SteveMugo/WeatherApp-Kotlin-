package com.example.appkkweather.domain.datasource.searchCities

//import com.algolia.search.client.
//search.saas.places.PlacesClient
//import com.algolia.search.client.ClientPlaces
//import com.algolia.search.model.places.PlacesQuery
//import com.algolia.search.model.search.Language
import com.algolia.search.saas.places.PlacesClient
import com.algolia.search.saas.places.PlacesQuery

import com.example.appkkweather.domain.model.SearchResponse
import com.example.appkkweather.utils.extensions.tryCatch

import com.squareup.moshi.Moshi
import io.reactivex.Single
import javax.inject.Inject
import timber.log.Timber

class SearchCitiesRemoteDataSource @Inject constructor(
    private val client: PlacesClient,
    private val moshi: Moshi
) {

    fun getCityWithQuery(query: String): Single<SearchResponse> {
        return Single.create { single ->
            val algoliaQuery = PlacesQuery(query)
//                .setLanguage("en")
//                .setHitsPerPage(25)

//            client.awaitSearchByText(algoliaQuery.toString(), placesQuery { "", {}}, actions = {})

//            client.searchPlaces(Language.English,algoliaQuery, null) ResponseSearchPlacesMono

            client.searchAsync(algoliaQuery) { json, exception ->
                if (exception == null) {
                    tryCatch(
                        tryBlock = {
                            val adapter = moshi.adapter<SearchResponse>(SearchResponse::class.java)
                            val data = adapter.fromJson(json.toString())

                            if (data?.hits != null) {
                                single.onSuccess(data)
                            }
                        },
                        catchBlock = {
                            Timber.e(it, it.localizedMessage)
                        }
                    )
                } else {
                    single.onError(Throwable("Can't find '$query'. Please try another one."))
                }
            }
        }
    }
}
