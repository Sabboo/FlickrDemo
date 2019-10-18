package com.example.flickrdemo.features.photos.presentation.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.flickrdemo.features.photos.data.model.Photo

@BindingAdapter("photosList")
fun populatePhotosRecyclerView(
    view: RecyclerView,
    photosList: List<Photo>?
) {
    var adapter = PhotosAdapter()
    if (view.adapter != null) {
        adapter = view.adapter as PhotosAdapter
        photosList?.let { adapter.setData(it) }
    } else
        view.adapter = adapter
}

@BindingAdapter("imageURL")
fun loadImageWithURL(
    view: ImageView,
    URL: String
) {
    Glide.with(view).load(URL)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
        .into(view)
}