package com.inbyte.inbook.view.ui.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewBinding> : Fragment() {

    protected lateinit var binding: B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=getFragmentBinding(inflater, container)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        initCtrl()
        observer()
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B
    abstract fun init()
    abstract fun initCtrl()
    abstract fun observer()


    open fun showBasicAlert(message: String) {
        lateinit var dialog: AlertDialog
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setMessage(message)
        val dialogClickListner = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {

                }
            }
        }
        builder?.setPositiveButton("OK", dialogClickListner)
        if (builder != null) {
            dialog = builder.create()
        }
        dialog.setOnShowListener {
            // need to set colour
        }
        dialog.show()
    }

    open fun showBasicAlert(title: String, message: String) {
        lateinit var dialog: AlertDialog
        val builder = activity?.let { AlertDialog.Builder(it) }
        builder?.setTitle(title)
        builder?.setMessage(message)
        val dialogClickListner = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> {

                }
            }
        }
        builder?.setPositiveButton("OK", dialogClickListner)
        if (builder != null) {
            dialog = builder.create()
        }
        dialog.setOnShowListener {
            // need to set colour
        }
        dialog.show()
    }


}