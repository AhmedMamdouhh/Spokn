package com.spokn.presentation.ui.profile.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spokn.databinding.ItemAlbumBinding
import com.spokn.domain.model.album.Album
import com.spokn.presentation.ui.profile.ProfileViewModel

class AlbumsAdapter(
    private val albumsList: ArrayList<Album>,
    private val profileViewModel: ProfileViewModel
) : RecyclerView.Adapter<AlbumsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder =
        AlbumsViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), profileViewModel
        )

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bind(albumsList[position])
    }

    override fun getItemCount() = albumsList.size


}
