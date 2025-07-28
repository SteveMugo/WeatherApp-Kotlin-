package com.example.appkkweather.data.cloud

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.android.volley.toolbox.Volley
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.appkkweather.R
import com.example.appkkweather.ui.favorite.FavoriteViewModel
import com.example.appkkweather.ui.favorite.favoriteCitiesWeather
import com.example.appkkweather.utils.Constants
import com.example.appkkweather.utils.ShowToast

class FavoriteDataModel(
    private val viewModel: FavoriteViewModel,
    private val context: Context?, val favprogressBar: ProgressBar?
) {

    //location shared SharedPreferences
    var pref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    val db = Firebase.firestore

    //add city to cloud fav db
    fun addCity(cityName: String, context: Context): Int {

        //city to be added
        val city = hashMapOf(cityName to cityName)

        val user = Firebase.auth.currentUser
        val email = user?.email.toString()

        // add city
        db.collection("cities")
            .document(email)
            .set(city, SetOptions.merge())
            .addOnSuccessListener { documentReference ->
                ShowToast().showSuccess(context, "$cityName successfully added")

                viewModel.favIcon = R.drawable.baseline_favorite_24
                viewModel.currentIcon.value = viewModel.favIcon
            }
            .addOnFailureListener { e ->
                ShowToast().showFailure(context, "Error adding: \t$cityName")
            }

        return viewModel.favIcon
    }

    //remove city from cloud fav db
    fun deleteCity(cityName: String, context: Context): Int {

        val user = Firebase.auth.currentUser
        val email = user?.email.toString()

        // Remove the 'capital' field from the document
        val updates = hashMapOf<String, Any>(
            cityName to FieldValue.delete()
        )

        db.collection("cities")
            .document(email)
            .update(updates)
            .addOnSuccessListener {
                ShowToast().showFailure(context, "$cityName removed from fav")
                viewModel.favIcon = R.drawable.baseline_favorite_border_24
                viewModel.currentIcon.value = viewModel.favIcon
            }
            .addOnFailureListener { e ->
                ShowToast().showFailure(context, "Unable to remove $cityName")
            }

        return viewModel.favIcon
    }


    //check if a city exist
    fun checkCityExistence(city: String) {

        val user = Firebase.auth.currentUser
        val email = user?.email.toString()

        val docRef = db.collection("cities").document(email)

        docRef.get()
            .addOnSuccessListener { document ->

                if (document != null) { //check if document is empty

                    val cities = document.data //get data

                    val data = cities?.values

                    if (data != null) {
                        val foundValue = data.find { item -> item == city }

//                        Log.d("Data:::>>>>>>>>>>>>>>>>>>>>>", data.toString())
//                        Log.d("foundValue:::::>>>>>>>>>>>>>>>>>>>>>", foundValue.toString())

                        if (foundValue != null) {
                            viewModel.favIcon = R.drawable.baseline_favorite_24
                            viewModel.currentIcon.value = viewModel.favIcon
                        } else {
                            viewModel.favIcon = R.drawable.baseline_favorite_border_24
                            viewModel.currentIcon.value = viewModel.favIcon
                        }
                    } else {
                        viewModel.favIcon = R.drawable.baseline_favorite_border_24
                        viewModel.currentIcon.value = viewModel.favIcon
                    }
                } else {
                    viewModel.favIcon = R.drawable.baseline_favorite_border_24
                }
            }
            .addOnFailureListener { exception ->
                viewModel.favIcon = R.drawable.baseline_favorite_border_24
            }
    }


    //get all cities
    fun getAllCities() {
        pref = context?.getSharedPreferences("location", Context.MODE_PRIVATE)
        editor = pref?.edit()

        val latitude = pref?.getString("latitude", "").toString()
        val longitude = pref?.getString("longitude", "").toString()
//        cityWeather(viewModel).showCitiesWeather(context)
        val queue = Volley.newRequestQueue(context)
        val url =
            "${Constants.BASE_URL_FORECAST}lat=$latitude&lon=$longitude&appid=${Constants.OPEN_WEATHER_API_KEY}"

        Log.d("Cities from getAllCities", url.toString())

        val user = Firebase.auth.currentUser
        val email = user?.email.toString()

        favprogressBar?.isVisible = true

        val docRef = db.collection("cities").document(email)

        docRef.get()
            .addOnSuccessListener { document ->

                favprogressBar?.isVisible = true

                if (document != null) {

                    val names = document.data

                    if (names != null) {

                        for (cityName in names.values) {

                            val cities = listOf(cityName)
                            favprogressBar?.isVisible = false

                            if (cityName != null) {
                                favoriteCitiesWeather(
                                    viewModel,
                                    cities as List<String?>
                                ).showCitiesWeather(context, favprogressBar)
                            }
                        }
                    }

                } else {

                    ShowToast().showFailure(context, "Failed to fetch your favorite cities, ")
                }
            }
            .addOnFailureListener { exception ->

                ShowToast().showFailure(context, "Failed: Make sure you are connected. ")
            }
    }

}