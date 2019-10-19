package com.example.flickrdemo.features.slider.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrdemo.R
import com.example.flickrdemo.databinding.ItemPagerPhotoBinding
import com.example.flickrdemo.features.photos.data.model.Photo

class PhotosPagerAdapter(private val photosList: List<Photo>) :
    RecyclerView.Adapter<PhotosPagerAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = DataBindingUtil.inflate<ItemPagerPhotoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_pager_photo, parent, false
        )
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    class PhotoViewHolder(private val binding: ItemPagerPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.obj = photo
            binding.executePendingBindings()
        }

    }

}