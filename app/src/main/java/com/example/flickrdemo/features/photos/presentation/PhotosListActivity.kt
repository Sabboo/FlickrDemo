package com.example.flickrdemo.features.photos.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.flickrdemo.R
import com.example.flickrdemo.utilities.showToast
import org.koin.core.KoinComponent
import org.koin.core.inject

class PhotosListActivity : AppCompatActivity(), KoinComponent {

    private val viewModel by inject<PhotosListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos_list)

        viewModel.errorMessage.observe(this,
            Observer { message -> showToast(message) })

        viewModel.getPhotosList(1)
    }
}
