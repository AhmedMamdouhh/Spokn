package com.spokn.domain.model.user

import com.google.gson.annotations.SerializedName

data class UserAddress(
    @SerializedName("street")
    var addressStreet: String = "",

    @SerializedName("suite")
    var addressSuite: String = "",

    @SerializedName("city")
    var addressCity: String = "",

    @SerializedName("zipcode")
    var addressZipcode: String = ""
) {
    override fun toString(): String {
        return "$addressStreet, $addressSuite, $addressCity, $addressZipcode"
    }
}