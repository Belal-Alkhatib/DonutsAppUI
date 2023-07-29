package com.uog.donutsuiapp.ui.composables

import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.uog.donutsuiapp.ui.theme.White

fun setStatusBarColor(
    color: Color = White,
    systemUIController: SystemUiController
) {
    systemUIController.setStatusBarColor(color)
}