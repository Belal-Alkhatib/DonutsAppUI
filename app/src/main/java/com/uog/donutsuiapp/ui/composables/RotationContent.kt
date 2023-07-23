package com.uog.donutsuiapp.ui.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import kotlinx.coroutines.delay

@Composable
fun RotationContent(
    modifier: Modifier = Modifier,
    startScale: Boolean = false,
    content: @Composable () -> Unit
) {
    val imageRotation = remember { Animatable(0f) }

    LaunchedEffect(key1 = startScale){
        imageRotation.animateTo(360f, tween(2200, easing = FastOutSlowInEasing))
        delay(200)
        imageRotation.animateTo(0f, tween(1200, easing = FastOutSlowInEasing))

    }
    Box(
        modifier = modifier.rotate(imageRotation.value)
    ) {
        content()
    }

}