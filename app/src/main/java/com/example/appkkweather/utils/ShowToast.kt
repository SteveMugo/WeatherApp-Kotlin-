package com.example.appkkweather.utils

import android.content.Context

class ShowToast {

    //show success toast
    fun showSuccess(context: Context?, message: String) {
        if (context != null) {
//            Toasty.success(
//                context, message,
//                Toast.LENGTH_SHORT,
//                true
//            ).show()
        }
    }


    //show warning failure toast
    fun showFailure(context: Context?, message: String) {
        if (context != null) {
//            Toasty.error(
//                context, message,
//                Toast.LENGTH_SHORT, true
//            ).show()
        }
    }
}