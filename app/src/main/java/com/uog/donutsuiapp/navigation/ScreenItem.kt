package com.uog.donutsuiapp.navigation

import androidx.annotation.DrawableRes

data class ScreenItem(
    val rout: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int
)