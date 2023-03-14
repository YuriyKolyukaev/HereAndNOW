package com.yuriykyus.walry.presentation.events

import com.yuriykyus.walry.presentation.fragments.FragmentTypes

sealed class MainEvent(val type: FragmentTypes?)

class LoadCityEvent(type: FragmentTypes?) : MainEvent(type)

class LoadPhotosEvent(type: FragmentTypes?) : MainEvent(type) {

}