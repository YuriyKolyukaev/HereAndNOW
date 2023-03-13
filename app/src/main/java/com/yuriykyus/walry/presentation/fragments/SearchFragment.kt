package com.yuriykyus.walry.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuriykyus.walry.core.AppConstants
import com.yuriykyus.walry.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment() {
    companion object {
        fun newInstance() = SearchFragment()
    }

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun getTitle(): String {
        return AppConstants.SEARCH_FRAGMENT
    }
}