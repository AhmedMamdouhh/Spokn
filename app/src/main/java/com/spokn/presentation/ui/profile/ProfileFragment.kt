package com.spokn.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.spokn.databinding.FragmentProfileBinding
import com.spokn.manager.utilities.EventObserver
import com.spokn.manager.utilities.recyclerAnimationExtension
import com.spokn.presentation.ui.profile.albums.AlbumsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var profileBinding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var albumsAdapter: AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        profileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        profileBinding.profileListener = profileViewModel

        observeUserDetails()
        observeAlbumClicked()

        return profileBinding.root
    }

    private fun observeAlbumClicked() {
        profileViewModel.observeAlbumClicked.observe(viewLifecycleOwner, EventObserver { album ->
            val action = ProfileFragmentDirections.actionProfileToPhotosDialog(album.albumId,album.albumTitle)
            findNavController().navigate(action)
        })
    }

    private fun observeUserDetails() {
        profileViewModel.observeUserDetails.observe(viewLifecycleOwner, EventObserver { user ->
            profileBinding.apply {
                clProfileParent.visibility = VISIBLE
                rvProfileAlbumsList.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(requireContext())
                    albumsAdapter = AlbumsAdapter(user.userAlbums!!, profileViewModel)
                    recyclerAnimationExtension(this)
                    adapter = albumsAdapter
                }
                userObject = user
            }

        })
    }
}