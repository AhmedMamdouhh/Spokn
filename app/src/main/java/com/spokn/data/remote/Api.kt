package com.spokn.data.remote

import com.spokn.domain.model.Album
import com.spokn.domain.model.User
import com.spokn.manager.utilities.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(ApiEndPoints.GET_USERS)
    fun getUsers():Single<List<User>>

    @GET(ApiEndPoints.GET_ALBUMS)
    fun getAlbums(
        @Query(Constants.USER_ID)
         userId:Int = 1
    ):Single<ArrayList<Album>>

}