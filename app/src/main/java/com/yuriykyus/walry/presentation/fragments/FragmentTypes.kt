package com.yuriykyus.walry.presentation.fragments

import com.yuriykyus.walry.core.AppConstants

enum class FragmentTypes(val requestTag: String, val requestText: String, val title: String) {
    NewWallpaperFragment(
        requestTag = AppConstants.NEW_WALLPAPER_TAG,
        requestText = AppConstants.NEW_WALLPAPER_TEXT,
        title = AppConstants.NEW_WALLPAPER_TITLE
    ),
    IllustrationFragment(
        requestTag = AppConstants.ILLUSTRATION_TAG,
        requestText = AppConstants.ILLUSTRATION_TEXT,
        title = AppConstants.ILLUSTRATION_TITLE
    ),
    PopWallpaperFragment(
        requestTag = AppConstants.POP_WALLPAPER_TAG,
        requestText = AppConstants.POP_WALLPAPER_TEXT,
        title = AppConstants.POP_WALLPAPER_TITLE
    )
}