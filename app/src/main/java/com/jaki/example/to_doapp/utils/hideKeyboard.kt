package com.jaki.example.to_doapp.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

fun hideKeyboard(activity: Activity){
    val inpMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentFocusedView = activity.currentFocus
    currentFocusedView.let {
        inpMethodManager.hideSoftInputFromWindow(
            currentFocusedView?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}