package com.example.flickrdemo.utilities

import android.view.View

interface GenericItemClickListener<T> {

    fun onItemClick(view: View, obj: T)

}