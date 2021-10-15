package com.spokn.domain.model.user

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR
import com.spokn.domain.model.album.Album

class User : BaseObservable() {

    @SerializedName("id")
    @get:Bindable
    var userId: Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.userId)
        }

    @SerializedName("name")
    @get:Bindable
    var userName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userName)
        }

    @SerializedName("address")
    @get:Bindable
    var userAddress: UserAddress?=null
        set(value) {
            field = value
            notifyPropertyChanged(BR.userAddress)
        }

    @get:Bindable
    var userAlbums: ArrayList<Album>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.userAlbums)
        }

     fun splitUserName():String{
        return userName.replaceFirst(" ","\n")
    }
}

