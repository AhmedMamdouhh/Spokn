package com.spokn.data.repository.photos

import com.spokn.data.remote.Api
import javax.inject.Inject

class PhotosRepository @Inject constructor(
    private val api: Api
): PhotosRepositoryGateway {

    override fun requestPhotos(albumId: Int) = api.getPhotos(albumId)

}