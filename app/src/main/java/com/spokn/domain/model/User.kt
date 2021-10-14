package com.spokn.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.spokn.BR
import io.reactivex.Single

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
    var userAddress: UserAddress? = null
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
}

data class UserAddress(
    @SerializedName("street")
    var addressStreet: String = "",

    @SerializedName("suite")
    var addressSuite: String = "",

    @SerializedName("city")
    var addressCity: String = "",

    @SerializedName("zipcode")
    var addressZipcode: String = ""
)

interface UserGateway{
    fun requestUser():Single<List<User>>
}