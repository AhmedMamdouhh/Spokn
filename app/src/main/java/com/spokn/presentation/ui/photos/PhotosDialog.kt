package com.spokn.presentation.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.spokn.databinding.DialogPhotosBinding
import com.spokn.manager.base.BaseBottomSheet
import com.spokn.manager.utilities.*
import com.spokn.presentation.ui.photos.photos_list.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosDialog : BaseBottomSheet() {

    private lateinit var photoBinding: DialogPhotosBinding
    private lateinit var photosAdapter: PhotosAdapter
    private val photosViewModel: PhotosViewModel by viewModels()
    private val args:PhotosDialogArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        photoBinding = DialogPhotosBinding.inflate(inflater,container,false)

        init()
        observePhotos()
        observeCloseClicked()
        observePhotoClicked()

        return photoBinding.root
    }


    private fun init(){
        photosViewModel.requestPhotos(args.albumId)
        photoBinding.apply {
            photoListener = photosViewModel
            albumTitle = args.albumTitle
        }
        this.isCancelable = false
    }

    private fun observeCloseClicked() {
        photosViewModel.observeCloseClicked.observe(viewLifecycleOwner,EventObserver{
            closeSheet()
        })
    }

    private fun observePhotoClicked() {
        photosViewModel.observePhotoClicked.observe(viewLifecycleOwner,EventObserver{photoUrl->
            showSinglePhotoExtension(photoUrl)
        })
    }


    private fun observePhotos() {
        photosViewModel.observePhotos.observe(viewLifecycleOwner,EventObserver{photos->
            photosAdapter = PhotosAdapter(photos,photosViewModel)
            photoBinding.rvPhotosList.apply {
                setHasFixedSize(true)
                recyclerAnimationExtension(this)
                layoutManager = GridLayoutManager(requireContext(),Constants.SPAN_COUNT)
                adapter = photosAdapter
            }
        })
    }
}