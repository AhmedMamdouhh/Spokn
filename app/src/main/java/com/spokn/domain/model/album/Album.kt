package com.spokn.domain.model.album

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR


class Album : BaseObservable() {


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