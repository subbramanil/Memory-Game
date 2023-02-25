package com.android.nikhil.memorygame

import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.android.nikhil.memorygame.databinding.DialogGameBinding

class GameDialog : DialogFragment() {

    companion object {
        fun newInstance(message: String): GameDialog {
            val frag = GameDialog()
            val args = Bundle()
            args.putString("message", message)
            frag.arguments = args
            return frag
        }
    }

    private var dismissListener: DialogInterface.OnDismissListener? = null

    fun setOnDismissListener(listener: DialogInterface.OnDismissListener?): GameDialog {
        dismissListener = listener
        return this
    }

    @Deprecated("Deprecated in Java")
    override fun onDismiss(dialog: DialogInterface?) {
        dismissListener?.onDismiss(dialog)
        super.onDismiss(dialog)
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogGameBinding.inflate(activity.layoutInflater)
        val view = binding.root
        val message = arguments.getString("message")
        message?.let { binding.message.text = it }
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setContentView(view)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}