package com.inbyte.inbook.utils.common

import android.content.ContextWrapper
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.inbyte.inbook.R
import com.inbyte.inbook.view.ui.loader.ErrorDialog

object ErrorUtil {

    fun showError(view: View?, message: String?) {
        try {

            val dialog = ErrorDialog()
            val bundle = Bundle()
            bundle.putString("message", message)
            dialog.arguments = bundle
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Dialog_NoTitle)

            when (view?.context) {
                is AppCompatActivity -> dialog.show(
                    (view.context as AppCompatActivity).supportFragmentManager,
                    ""
                )
                is ContextWrapper -> dialog.show(
                    (((view.context as ContextWrapper).baseContext) as AppCompatActivity).supportFragmentManager,
                    ""
                )
            }

        } catch (e: Exception) {

        }
    }
}