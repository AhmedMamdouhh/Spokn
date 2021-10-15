package com.spokn.domain.model.photo

import io.reactivex.Single

interface PhotoGateway{
    fun requestPhotos(albumId:Int): Single<ArrayList<Photo>>
}