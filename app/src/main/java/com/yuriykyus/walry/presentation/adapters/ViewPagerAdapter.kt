package com.yuriykyus.walry.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yuriykyus.walry.core.AppConstants
import com.yuriykyus.walry.presentation.fragments.*

class ViewPagerAdapter(fragment: FragmentManager, lifeCircle: androidx.lifecycle.Lifecycle) :
    FragmentStateAdapter(fragment, lifeCircle) {

    private val categoriesFragment = CategoriesFragment.newInstance()
    private val cityFragment = CityFragment.newInstance()

    private val newWallpaperFragment = WallppaperFragment.newInstance(
        FragmentTypes.NewWallpaperFragment.requestTag,
        FragmentTypes.NewWallpaperFragment.requestText
    )
    private val popWallpaperFragment = WallppaperFragment.newInstance(
        FragmentTypes.PopWallpaperFragment.requestTag,
        FragmentTypes.PopWallpaperFragment.requestText
    )
    private val illustrationFragment = WallppaperFragment.newInstance(
        FragmentTypes.IllustrationFragment.requestTag,
        FragmentTypes.IllustrationFragment.requestText
    )

    private val fragments = arrayOf(
        categoriesFragment,
        cityFragment,
        newWallpaperFragment,
        popWallpaperFragment,
        illustrationFragment
    )

    val fragmentName =
        arrayOf(
            AppConstants.CATEGORY_FRAGMENT_TITLE,
            AppConstants.CITY_FRAGMENT_TITLE,
            FragmentTypes.NewWallpaperFragment.title,
            FragmentTypes.PopWallpaperFragment.title,
            FragmentTypes.IllustrationFragment.title
        )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}