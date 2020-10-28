package com.android.practice.practice.fragment.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.android.practice.practice.R
import java.lang.RuntimeException

private const val ARG_TITLE = "title"
private const val ARG_MESSAGE = "message"
private const val ARG_ICON = "icon"

class DialogFragmentImpl : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var message: String? = null
    private var icon: Int? = null

    private var positiveClickListener: OnPositiveClickListener? = null
    private var negativeClickListener: OnNegativeClickListener? = null
    private var neutralClickListener: OnNeutralClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnPositiveClickListener) {
            positiveClickListener = context
        } else {
            throw RuntimeException("Please implement listener: Positive")
        }

        if(context is OnNegativeClickListener) {
            negativeClickListener = context
        } else {
            throw RuntimeException("Please implement listener: Negative")
        }

        if(context is OnNeutralClickListener) {
            neutralClickListener = context
        } else {
            throw RuntimeException("Please implement listener: Neutral")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            message = it.getString(ARG_MESSAGE)
            icon = it.getInt(ARG_ICON)
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setIcon(icon!!)
                .setPositiveButton("YES") { _, _ ->
                    positiveClickListener?.onPositiveButtonClicked()
                }
                .setNegativeButton("NO") { _, _ ->
                    negativeClickListener?.onNegativeButtonClicked()
                }
                .setNeutralButton("Cancel") { _, _ ->
                    neutralClickListener?.onNeutralButtonClicked()
                }
                .create()
        }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        positiveClickListener = null
        negativeClickListener = null
        neutralClickListener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, message: String, icon: Int) =
            DialogFragmentImpl().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_MESSAGE, message)
                    putInt(ARG_ICON, icon)
                }
            }
    }
}