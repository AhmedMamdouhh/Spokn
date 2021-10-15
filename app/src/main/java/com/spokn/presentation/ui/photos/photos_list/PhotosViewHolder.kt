package com.spokn.presentation.ui.photos.photos_list

import androidx.recyclerview.widget.RecyclerView
import com.spokn.databinding.ItemPhotoBinding
import com.spokn.domain.model.photo.Photo
import com.spokn.presentation.ui.photos.PhotosViewModel


class PhotosViewHolder(
    private val itemPhotoBinding: ItemPhotoBinding,
    private val photosViewModel: PhotosViewModel
) : RecyclerView.ViewHolder(itemPhotoBinding.root) {


    fun bind(photo: Photo) {
        itemPhotoBinding.photoObject = photo
        itemPhotoBinding.photoListener = photosViewModel
    }
}