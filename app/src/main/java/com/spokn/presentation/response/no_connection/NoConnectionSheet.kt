package com.spokn.presentation.response.no_connection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.spokn.manager.base.BaseBottomSheet
import com.spokn.R
import com.spokn.databinding.LayoutNoConnectionBinding

class NoConnectionSheet : BaseBottomSheet() {
    private lateinit var noConnectionBinding: LayoutNoConnectionBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noConnectionBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_no_connection, container, false)
        noConnectionBinding.lifecycleOwner = this
        noConnectionBinding.clickListener = this

        return noConnectionBinding.root
    }

    fun onCloseClicked() {
        closeSheet()
    }


}

