package com.yuriykyus.walry.presentation.fragments

import com.yuriykyus.walry.core.AppConst

enum class FragmentTypes(val requestTag: String, val requestText: String, val title: String) {
    CityPhotos(
        requestTag = AppConst.CITY_PHOTOS_TAG,
        requestText = AppConst.CITY_PHOTOS_TEXT,
        title = AppConst.CITY_PHOTOS_TITLE
    ),

    NewWallpaper(
        requestTag = AppConst.NEW_WALLPAPER_TAG,
        requestText = AppConst.NEW_WALLPAPER_TEXT,
        title = AppConst.NEW_WALLPAPER_TITLE
    ),

    Illustration(
        requestTag = AppConst.ILLUSTRATION_TAG,
        requestText = AppConst.ILLUSTRATION_TEXT,
        title = AppConst.ILLUSTRATION_TITLE
    ),

    PopWallpaper(
        requestTag = AppConst.POP_WALLPAPER_TAG,
        requestText = AppConst.POP_WALLPAPER_TEXT,
        title = AppConst.POP_WALLPAPER_TITLE
    )
}