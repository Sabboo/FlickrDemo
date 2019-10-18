package com.example.flickrdemo.features.photos.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
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
        setAnimation(holder.itemView)
    }

    private fun setAnimation(viewToAnimate: View) {
        val animation =
            AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
        animation.duration = 1000
        viewToAnimate.startAnimation(animation)
    }

    class PhotosHolder(private val itemPhotoBinding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(itemPhotoBinding.root) {

        fun bind(photo: Photo) {
            itemPhotoBinding.obj = photo
            itemPhotoBinding.executePendingBindings()
        }

    }
}