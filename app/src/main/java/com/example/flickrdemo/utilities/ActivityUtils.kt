package com.example.flickrdemo.utilities

import android.content.Context
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT

fun getScreenOrientation(context: Context): Int {
    return if (context.resources.configuration.orientation == ORIENTATION_PORTRAIT)
        ORIENTATION_PORTRAIT
    else
        ORIENTATION_LANDSCAPE
}