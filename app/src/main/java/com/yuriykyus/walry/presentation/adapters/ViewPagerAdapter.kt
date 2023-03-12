package com.yuriykyus.walry.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yuriykyus.walry.presentation.fragments.*

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    private val fragments = arrayOf(
        CategoriesFragment.newInstance(),
        CityFragment.newInstance(),
        NewWallpaperFragment.newInstance(),
        PopWallpaperFragment.newInstance(),
        IllustrWallppaperFragment.newInstance()
    )

    val fragmentName =
        arrayOf(
            CategoriesFragment.newInstance().getTitle(),
            CityFragment.newInstance().getTitle(),
            NewWallpaperFragment.newInstance().getTitle(),
            PopWallpaperFragment.newInstance().getTitle(),
            IllustrWallppaperFragment.newInstance().getTitle()
        )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}