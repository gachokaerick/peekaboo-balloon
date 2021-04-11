package com.delight.labs.games.helper.utils

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SimpleAlertDialog : DialogFragment() {
    companion object {
        private val TITLE_KEY = "title_key"
        private val MESSAGE_KEY = "message_key"

        fun newInstance(title: String?, message: String?): SimpleAlertDialog {
            val args = Bundle()
            args.putString(TITLE_KEY, title)
            args.putString(MESSAGE_KEY, message)
            val fragment = SimpleAlertDialog()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val args = arguments ?: throw AssertionError()
        val title = args.getString(TITLE_KEY)
        val prompt = args.getString(MESSAGE_KEY)
        val builder: AlertDialog.Builder =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AlertDialog.Builder(requireContext(), android.R.style.Theme_Material_Dialog_Alert)
            } else {
                AlertDialog.Builder(requireContext())
            }
                .setTitle(title)
                .setMessage(prompt)
                .setCancelable(false)
        builder.setPositiveButton(android.R.string.ok, null)
        return builder.create()
    }
}