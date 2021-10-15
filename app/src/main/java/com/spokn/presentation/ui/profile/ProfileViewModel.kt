package com.spokn.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spokn.domain.model.album.Album
import com.spokn.domain.model.user.User
import com.spokn.domain.use_case.profile.ProfileUseCaseGateway
import com.spokn.manager.base.BaseViewModel
import com.spokn.manager.base.ResponseManager
import com.spokn.manager.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCaseGateway,
    private val responseManager: ResponseManager
) : BaseViewModel() {

    private val _observeUserDetails = MutableLiveData<Event<User>>()
    private val _observeAlbumClicked = MutableLiveData<Event<Album>>()


    init {
        requestProfileData()
    }


    //Api call:
    private fun requestProfileData(){
        responseManager.loading()
        val disposable =  profileUseCase.execute({userDetails->
            responseManager.hideLoading()
            _observeUserDetails.value = Event(userDetails)
        }, {errorMessage->
            responseManager.hideLoading()
            if(errorMessage.contains("host"))
                responseManager.noConnection()
            else
                responseManager.failed(errorMessage)
        })

        compositeDisposable.add(disposable)
    }


    //Click:
    fun onAlbumClicked(album : Album){
        _observeAlbumClicked.value = Event(album)
    }

    //Getters:
    val observeUserDetails: LiveData<Event<User>>
        get() = _observeUserDetails
    val observeAlbumClicked: LiveData<Event<Album>>
        get() = _observeAlbumClicked
}