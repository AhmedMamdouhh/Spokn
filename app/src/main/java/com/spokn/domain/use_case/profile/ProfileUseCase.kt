package com.spokn.domain.use_case.profile

import com.spokn.data.repository.profile.ProfileRepositoryGateway
import com.spokn.domain.model.user.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepositoryGateway
) : ProfileUseCaseGateway {

    private lateinit var user: User


    override fun execute(
        successConsumer: Consumer<User>,
        errorConsumer: Consumer<String>
    ): Disposable {
        return profileRepository.requestUser()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMap { userList ->
                user = userList[randomUser()]
                profileRepository.requestAlbums(user.userId)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .map { albumsList ->
                user.userAlbums = albumsList
            }
            .subscribe(
                { successConsumer.accept(user) },
                { errorConsumer.accept(it.toString()) })

    }

    private fun randomUser() = (0..9).random()

}