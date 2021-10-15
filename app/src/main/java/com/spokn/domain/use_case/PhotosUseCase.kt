package com.spokn.domain.use_case

import com.spokn.data.repository.photos.PhotosRepositoryGateway
import com.spokn.domain.model.Photo
import com.spokn.domain.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepositoryGateway
) {

    private lateinit var photos:ArrayList<Photo>

    fun execute(
        albumId:Int,
        successConsumer: Consumer<ArrayList<Photo>>,
        errorConsumer: Consumer<String>
    ): Disposable {
        return photosRepository.requestPhotos(albumId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                photos = it
            }
            .subscribe(
                {successConsumer.accept(photos)},
                {errorConsumer.accept("ERROR")}
            )

    }
}