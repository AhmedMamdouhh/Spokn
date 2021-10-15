package com.spokn.domain.model.album

import io.reactivex.Single


interface AlbumsGateway {
    fun requestAlbums(userId: Int): Single<ArrayList<Album>>
}