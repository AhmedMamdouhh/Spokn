package com.spokn.domain.use_case

import com.spokn.data.repository.profile.ProfileRepositoryGateway
import com.spokn.domain.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepositoryGateway
) {

    private lateinit var user: User


    fun execute(
        successConsumer: Consumer<User>,
        errorConsumer: Consumer<String>
    ): Disposable {
        return profileRepository.requestUser()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMap { userList ->
                user = userList[5]
                profileRepository.requestAlbums(user.userId)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .map { albumsList ->
                user.userAlbums = albumsList
            }
            .subscribe(
                { successConsumer.accept(user) },
                { errorConsumer.accept("ERROR") })

    }

}