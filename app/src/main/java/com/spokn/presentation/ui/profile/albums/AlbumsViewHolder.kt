package com.spokn.presentation.ui.profile.albums

import androidx.recyclerview.widget.RecyclerView
import com.spokn.databinding.ItemAlbumBinding
import com.spokn.domain.model.album.Album
import com.spokn.presentation.ui.profile.ProfileViewModel


class AlbumsViewHolder(
    private val itemAlbumBinding: ItemAlbumBinding,
    private val profileViewModel: ProfileViewModel
) : RecyclerView.ViewHolder(itemAlbumBinding.root) {


    fun bind(album: Album) {
        itemAlbumBinding.albumObject = album
        itemAlbumBinding.albumListener = profileViewModel
    }
}