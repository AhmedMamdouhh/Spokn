package com.spokn.manager.utilities

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.databinding.DataBindingUtil
import com.spokn.R
import com.spokn.databinding.DialogSinglePhotoBinding


fun recyclerAnimationExtension(recyclerView: RecyclerView) {
    val resId: Int = R.anim.layout_animation
    val animation: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(recyclerView.context, resId)
    recyclerView.layoutAnimation = animation
}


@SuppressLint("ClickableViewAccessibility")
fun Fragment.showSinglePhotoExtension(photoUrl: String) {
    val dialogBinding: DialogSinglePhotoBinding? =
        DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.dialog_single_photo,
            null,
            false
        )

    val customDialog = AlertDialog.Builder(requireContext(), 0).create()

    customDialog.apply {
        setView(dialogBinding?.root)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }.show()

    dialogBinding?.photoUrl = photoUrl

}