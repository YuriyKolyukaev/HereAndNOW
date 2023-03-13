package com.yuriykyus.walry.presentation

import com.yuriykyus.walry.presentation.fragments.BaseFragment

interface Navigator {
    fun addFragment(fragment: BaseFragment)
    fun backFragment()
    fun hideLoad()
    fun showLoad()
}