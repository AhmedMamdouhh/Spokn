package com.spokn.data.repository.profile

import com.spokn.data.remote.Api
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val api: Api
): ProfileRepositoryGateway {

    override fun requestUser() = api.getUsers()
    override fun requestAlbums(userId: Int) = api.getAlbums(userId)
}