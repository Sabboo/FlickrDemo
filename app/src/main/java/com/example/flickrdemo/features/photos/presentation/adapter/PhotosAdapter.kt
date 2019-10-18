package com.example.flickrdemo.features.photos.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrdemo.R
import com.example.flickrdemo.databinding.ItemPhotoBinding
import com.example.flickrdemo.features.photos.data.model.Photo
import com.example.flickrdemo.utilities.Constants.Companion.PHOTOS_PAGE_LIMIT

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosHolder>() {

    private var photosList = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosHolder {
        val binding = DataBindingUtil.inflate<ItemPhotoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_photo, parent, false
        )
        return PhotosHolder(binding)
    }

    fun setData(items: List<Photo>) {
        photosList.addAll(items)
        notifyItemRangeChanged(itemCount - PHOTOS_PAGE_LIMIT, itemCount)
    }

    override fun getItemCount() = photosList.size

    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {
        holder.bind(photosList[position])
    }

    class PhotosHolder(private val itemPhotoBinding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(itemPhotoBinding.root) {

        fun bind(photo: Photo) {
            itemPhotoBinding.obj = photo
            itemPhotoBinding.executePendingBindings()
        }

    }
}