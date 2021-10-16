package com.spokn.presentation.ui.photos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spokn.domain.model.photo.Photo
import com.spokn.domain.use_case.photo.PhotosUseCaseGateway
import com.spokn.manager.base.BaseViewModel
import com.spokn.manager.base.ResponseManager
import com.spokn.manager.utilities.Constants
import com.spokn.manager.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val photosUseCase: PhotosUseCaseGateway,
    private val responseManager: ResponseManager
) : BaseViewModel() {

    private val _observePhotos = MutableLiveData<Event<ArrayList<Photo>>>()
    private val _observeCloseClicked = MutableLiveData<Event<Boolean>>()
    private val _observePhotoClicked = MutableLiveData<Event<String>>()
    private val _observeErrorHappened =  MutableLiveData<Event<Boolean>>()

    private lateinit var photosList: ArrayList<Photo>


    fun requestPhotos(albumId: Int) {
        responseManager.loading()
        photosUseCase.execute(albumId,
            { photos ->
                responseManager.hideLoading()
                _observePhotos.value = Event(photos)
                photosList = photos

            }, { errorMessage ->
                responseManager.hideLoading()
                _observeErrorHappened.value = Event(true)
                if (errorMessage.contains("host"))
                    responseManager.noConnection()
                else
                    responseManager.failed(errorMessage)
            })
    }

    //Click:
    fun onCloseClicked() {
        _observeCloseClicked.value = Event(true)
    }

    fun onPhotoClicked(photoUrl: String) {
        _observePhotoClicked.value = Event(photoUrl)
    }

    fun onSearchChange(s: CharSequence, start: Int, before: Int, count: Int) {
        Observable.create<CharSequence> { emitter ->
            emitter.onNext(s)
            emitter.onComplete()
        }
            .map { it.toString() }
            .subscribeBy(
                onNext = { photosListSearch(it) }
            )
    }

    private fun photosListSearch(keyWord: String) {
        val newList = ArrayList<Photo>()
        for (photo in photosList) {
            if (photo.photoTitle.contains(keyWord))
                newList.add(photo)
        }
        _observePhotos.value = Event(newList)
    }


    //Getters:
    val observePhotos: LiveData<Event<ArrayList<Photo>>>
        get() = _observePhotos
    val observeCloseClicked: LiveData<Event<Boolean>>
        get() = _observeCloseClicked
    val observeErrorHappened: LiveData<Event<Boolean>>
        get() = _observeErrorHappened
    val observePhotoClicked: LiveData<Event<String>>
        get() = _observePhotoClicked
}