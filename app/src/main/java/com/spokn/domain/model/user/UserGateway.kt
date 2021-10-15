package com.spokn.domain.model.user

import io.reactivex.Single

interface UserGateway {
    fun requestUser(): Single<List<User>>
}