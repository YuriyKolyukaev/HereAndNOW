package com.yuriykyus.walry.presentation.events

import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.domain.models.SearchData
import com.yuriykyus.walry.presentation.fragments.FragmentTypes

sealed class MainEvent(val type: FragmentTypes?)

class LoadCityEvent(type: FragmentTypes?) : MainEvent(type)

class LoadPhotosEvent(type: FragmentTypes?) : MainEvent(type)

class LoadPhotoSearchEvent(type: FragmentTypes?, val searchData: SearchData) : MainEvent(type)


