package com.spokn.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spokn.domain.model.User
import com.spokn.domain.use_case.ProfileUseCase
import com.spokn.manager.base.BaseViewModel
import com.spokn.manager.base.ResponseManager
import com.spokn.manager.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCase: ProfileUseCase,
    private val responseManager: ResponseManager
) : BaseViewModel() {

    private val _observeUserDetails = MutableLiveData<Event<User>>()
    private val _observeAlbumClicked = MutableLiveData<Event<Boolean>>()


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
            val message = errorMessage
        })

        compositeDisposable.add(disposable)
    }


    //Click:
    fun onAlbumClicked(albumId :Int){

    }

    //Getters:
    val observeUserDetails: LiveData<Event<User>>
        get() = _observeUserDetails
    val observeAlbumClicked: LiveData<Event<Boolean>>
        get() = _observeAlbumClicked
}