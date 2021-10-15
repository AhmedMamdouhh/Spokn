package com.spokn.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR
import io.reactivex.Single


class Album : BaseObservable() {

    @SerializedName("userId")
    @get:Bindable
    var userId : Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.userId)
        }

    @SerializedName("id")
    @get:Bindable
    var albumId :Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.albumId)
        }

    @SerializedName("title")
    @get:Bindable
    var albumTitle : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.albumTitle)
        }
}

interface AlbumsGateway {
    fun requestAlbums(userId: Int): Single<ArrayList<Album>>
}