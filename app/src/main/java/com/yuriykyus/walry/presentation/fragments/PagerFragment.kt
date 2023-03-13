package com.yuriykyus.walry.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.yuriykyus.walry.core.AppConstants
import com.yuriykyus.walry.databinding.FragmentPagerBinding
import com.yuriykyus.walry.presentation.adapters.ViewPagerAdapter

class PagerFragment : BaseFragment() {

    private var categoriesFragment: CategoriesFragment? = null
    private var cityFragment: CityFragment? = null
    private var newWallpaperFragment: NewWallpaperFragment? = null
    private var popWallpaperFragment: PopWallpaperFragment? = null
    private var illustrWallppaperFragment: IllustrWallppaperFragment? = null

    private val binding by lazy {
        FragmentPagerBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {

        }

        val viewPager = binding.viewPager

        viewPager.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager.isSaveEnabled = false

        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            val vp = viewPager.adapter as ViewPagerAdapter
            tab.text = vp.fragmentName[position]
        }.attach()

        binding.mainToolbar.apply {
            btnSearch.setOnClickListener {
                getNavigator().addFragment(SearchFragment.newInstance())
            }
        }
    }

    override fun getTitle(): String {
        return AppConstants.PAGER_FRAGMENT_NAME
    }

    private fun createFragmentsList(): List< BaseFragment> {
        return listOf(
            CategoriesFragment.newInstance(),
            CityFragment.newInstance(),
            NewWallpaperFragment.newInstance(),
            PopWallpaperFragment.newInstance(),
            IllustrWallppaperFragment.newInstance()
        )
    }
}