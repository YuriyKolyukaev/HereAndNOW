package com.yuriykyus.walry.presentation.fragments

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yuriykyus.walry.R
import com.yuriykyus.walry.presentation.Navigator

abstract class BaseFragment : Fragment() {
    fun getNavigator(): Navigator {
        return (requireActivity() as Navigator)
    }

    fun hideLoad() {
        (requireActivity() as Navigator).hideLoad()
    }

    fun showLoad() {
        (requireActivity() as Navigator).showLoad()
    }

    fun showDialog(message: String) {
        MaterialAlertDialogBuilder(requireActivity(), R.style.MyRounded_MaterialComponents_MaterialAlertDialog)
            .setMessage(message)
            .setPositiveButton("Ok", null)
            .show()
    }
}