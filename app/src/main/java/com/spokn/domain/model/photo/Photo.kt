package com.spokn.domain.model.photo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR

class Photo:BaseObservable() {


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