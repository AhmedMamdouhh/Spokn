package com.spokn.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR
import io.reactivex.Single

class Photo:BaseObservable() {

    @SerializedName("albumId")
    @get:Bindable
    var albumId : Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.albumId)
        }

    @SerializedName("id")
    @get:Bindable
    var photoId : Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoId)
        }

    @SerializedName("title")
    @get:Bindable
    var photoTitle :String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoTitle)
        }

    @SerializedName("url")
    @get:Bindable
    var photoUrl :String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoUrl)
        }

    @SerializedName("thumbnailUrl")
    @get:Bindable
    var photoThumbnailUrl:String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.photoThumbnailUrl)
        }

}

interface PhotoGateway{
    fun requestPhotos(albumId:Int): Single<ArrayList<Photo>>
}