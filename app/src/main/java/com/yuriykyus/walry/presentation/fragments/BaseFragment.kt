package com.yuriykyus.walry.presentation.fragments

import androidx.fragment.app.Fragment
import com.yuriykyus.walry.presentation.Navigator

abstract class BaseFragment : Fragment() {
    abstract fun getTitle(): String

     fun hideLoad() {
        (requireActivity() as Navigator).hideLoad()
    }

     fun showLoad() {
        (requireActivity() as Navigator).showLoad()
    }
}