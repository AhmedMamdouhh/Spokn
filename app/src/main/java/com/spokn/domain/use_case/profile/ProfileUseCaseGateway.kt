package com.spokn.domain.use_case.profile

import com.spokn.domain.model.user.User
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


interface ProfileUseCaseGateway {
    fun execute(
        successConsumer: Consumer<User>,
        errorConsumer: Consumer<String>
    ): Disposable
}