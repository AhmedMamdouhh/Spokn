package com.spokn.presentation.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spokn.domain.model.Photo
import com.spokn.domain.use_case.PhotosUseCase
import com.spokn.manager.base.BaseViewModel
import com.spokn.manager.base.ResponseManager
import com.spokn.manager.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val photosUseCase: PhotosUseCase,
    private val responseManager: ResponseManager
) : BaseViewModel() {

    private val _observePhotos = MutableLiveData<Event<ArrayList<Photo>>>()
    private val _observeCloseClicked = MutableLiveData<Event<Boolean>>()

    fun requestPhotos(albumId: Int) {
        responseManager.loading()
        photosUseCase.execute(albumId,
            { photos ->
                responseManager.hideLoading()
                _observePhotos.value = Event(photos)

            }, { errorMessage ->
                responseManager.hideLoading()
                val message = errorMessage
            })
    }

    //Click:
    fun onCloseClicked() {
        _observeCloseClicked.value = Event(true)
    }
    fun onPhotoClicked(){

    }


    //Getters:
    val observePhotos: LiveData<Event<ArrayList<Photo>>>
        get() = _observePhotos
    val observeCloseClicked: LiveData<Event<Boolean>>
        get() = _observeCloseClicked
}