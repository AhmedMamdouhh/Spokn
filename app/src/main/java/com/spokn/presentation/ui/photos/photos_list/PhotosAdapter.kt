package com.spokn.presentation.ui.photos.photos_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spokn.databinding.ItemPhotoBinding
import com.spokn.domain.model.Photo
import com.spokn.presentation.ui.photos.PhotosViewModel

class PhotosAdapter(
    private val photosList: ArrayList<Photo>,
    private val photosViewModel: PhotosViewModel
) : RecyclerView.Adapter<PhotosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), photosViewModel
        )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount() = photosList.size


}
