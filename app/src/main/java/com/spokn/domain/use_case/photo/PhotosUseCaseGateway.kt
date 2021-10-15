package com.spokn.domain.use_case.photo

import com.spokn.domain.model.photo.Photo
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

interface PhotosUseCaseGateway {
    fun execute(
        albumId:Int,
        successConsumer: Consumer<ArrayList<Photo>>,
        errorConsumer: Consumer<String>
    ): Disposable
}