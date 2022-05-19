package com.inbyte.inbook.view.ui.loader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inbyte.inbook.R
import com.inbyte.inbook.databinding.DialogErrorBinding
import com.inbyte.inbook.view.ui.base.BaseDialog

class ErrorDialog : BaseDialog<DialogErrorBinding>(), View.OnClickListener {

    override fun getDialogBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogErrorBinding = DialogErrorBinding.inflate(inflater, container, false)

    override fun init() {
    }

    override fun initCtrl() {
    }

    override fun observer() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnOk -> {
                dismiss()
            }
        }
    }
}