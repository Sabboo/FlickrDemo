package com.example.flickrdemo.features.slider.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flickrdemo.R
import com.example.flickrdemo.features.photos.data.model.Photo
import com.example.flickrdemo.features.slider.presentation.adapter.PhotosPagerAdapter
import kotlinx.android.synthetic.main.activity_slider.*
import java.util.*

class SliderActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PHOTOS_LIST = "list"
        private const val EXTRA_SELECTED_PHOTO_POSITION = "position"

        fun intentInstance(context: Context, photosList: List<Photo>, position: Int) =
            Intent(context, SliderActivity::class.java).apply {
                putParcelableArrayListExtra(EXTRA_PHOTOS_LIST, ArrayList(photosList))
                putExtra(EXTRA_SELECTED_PHOTO_POSITION, position)
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        val photosList = intent.getParcelableArrayListExtra<Photo>(EXTRA_PHOTOS_LIST).toList()
        val position = intent.getIntExtra(EXTRA_SELECTED_PHOTO_POSITION, 0)

        val adapter = PhotosPagerAdapter(photosList)
        vp_photos.adapter = adapter
        vp_photos.setCurrentItem(position, true)

    }
}
