package com.android.dan.testgithubapiapp.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentManager
import com.android.dan.testgithubapiapp.R

class ProgressDialogFragment : AppCompatDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.progres_dialog_fragment, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    companion object {

        private val FRAGMENT_TAG = ProgressDialogFragment::class.java.canonicalName

        fun newInstance() = ProgressDialogFragment()

        fun show(manager: FragmentManager) {
            if (manager.findFragmentByTag(FRAGMENT_TAG) == null) {
                newInstance().show(manager, FRAGMENT_TAG)
            }
        }

        fun dismiss(manager: FragmentManager) {
            val dialogFragment = manager
                .findFragmentByTag(FRAGMENT_TAG) as? ProgressDialogFragment
            dialogFragment?.dismissAllowingStateLoss()
        }
    }
}