package com.spokn.manager.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spokn.data.Resource
import com.spokn.manager.utilities.Event

class ResponseManager{

    private val _observeResponseManager = MutableLiveData<Event<Resource<Any>>>()

    fun loading() { setResponseObject(Resource.Loading()) }
    fun success(message: String) { setResponseObject(Resource.Success(message = message)) }
    fun failed(message: String) { setResponseObject(Resource.Failed(message)) }
    fun noConnection() { setResponseObject(Resource.NoConnection()) }
    fun hideLoading() { setResponseObject(Resource.HideLoading()) }


    private fun setResponseObject(message: Resource<Any>) {
        _observeResponseManager.value = Event(message)
    }


    //getters
    val observeResponseManager: LiveData<Event<Resource<Any>>>
        get() = _observeResponseManager

}