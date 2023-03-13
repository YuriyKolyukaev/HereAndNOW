package com.yuriykyus.walry.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yuriykyus.walry.presentation.fragments.*

class ViewPagerAdapter(fragment: FragmentManager, lifeCircle: androidx.lifecycle.Lifecycle) :
    FragmentStateAdapter(fragment, lifeCircle) {

    private val categoriesFragment = CategoriesFragment.newInstance()
    private val cityFragment = CityFragment.newInstance()
    private val newWallpaperFragment = NewWallpaperFragment.newInstance()
    private val popWallpaperFragment = PopWallpaperFragment.newInstance()
    private val illustrWallppaperFragment = IllustrWallppaperFragment.newInstance()



    private val fragments = arrayOf(
        categoriesFragment,
        cityFragment,
        newWallpaperFragment,
        popWallpaperFragment,
        illustrWallppaperFragment
    )

    val fragmentName =
        arrayOf(
            categoriesFragment.getTitle(),
            cityFragment.getTitle(),
            newWallpaperFragment.getTitle(),
            popWallpaperFragment.getTitle(),
            illustrWallppaperFragment.getTitle()
        )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}