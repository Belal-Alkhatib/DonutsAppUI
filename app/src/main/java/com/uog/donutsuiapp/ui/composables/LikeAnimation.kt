package com.uog.donutsuiapp.ui.composables


import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.smallIconSize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun LikeAnimation(modifier: Modifier = Modifier, selected: Boolean = false) {

    var isSelected by remember { mutableStateOf(selected) }

    val imageScale = remember { Animatable(1f) }
    val imageRotation = remember { Animatable(0f) }
    val orbOffset = remember { Animatable(0f) }
    val orbScale = remember { Animatable(0f) }

    val coroutineScope = rememberCoroutineScope()

    val favoriteIcon = if (isSelected) R.drawable.ic_favorit_fill else R.drawable.ic_favorit

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        SmallAngledButton(
            onClick = {
                isSelected = !isSelected
                if (isSelected) {
                    coroutineScope.launch {
                        orbOffset.animateTo(0f)
                        imageScale.animateTo(0.4f, tween(300, easing = LinearEasing))
                        imageRotation.animateTo(-30f, tween(300, easing = LinearEasing))
                    }

                    coroutineScope.launch {
                        delay(300)
                        coroutineScope.launch {
                            orbOffset.animateTo(orbOffset.value.minus(50f), tween(600))
                        }
                        coroutineScope.launch {
                            orbScale.animateTo(1f)
                            imageScale.animateTo(1f)
                            imageRotation.animateTo(0f)
                        }
                    }

                    coroutineScope.launch {
                        delay(600)
                        orbScale.animateTo(0f, tween(300))
                    }
                } else {
                    coroutineScope.launch {
                        imageScale.animateTo(1f)
                        imageRotation.animateTo(0f)
                        orbOffset.animateTo(0f)
                        orbScale.animateTo(0f)
                    }
                }

            },
            contentColor = Primary,
            shape = CircleShape,
            modifier = Modifier
                .size(smallIconSize)

        ) {
            Icon(
                painter = painterResource(id = favoriteIcon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .scale(imageScale.value)
                    .rotate(imageRotation.value)
            )
        }
    }

}


//package com.uog.donutsuiapp.ui.composables
//
//
//import android.annotation.SuppressLint
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.*
//import androidx.compose.material3.Icon
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.rotate
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.uog.donutsuiapp.R
//import com.uog.donutsuiapp.ui.theme.Primary
//import com.uog.donutsuiapp.ui.theme.smallIconSize
//import com.uog.donutsuiapp.ui.theme.space4
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@SuppressLint("SuspiciousIndentation")
//@Composable
//fun LikeAnimation(modifier: Modifier = Modifier, selected: Boolean = false) {
//    var isSelected by remember { mutableStateOf(selected) }
//
//    val imageScale = remember { Animatable(1f) }
//
//    val imageRotation = remember { Animatable(0f) }
//
//    val orbOffset = remember { Animatable(0f) }
//
//    val orbScale = remember { Animatable(0f) }
//
//    val favoriteIcon = if (isSelected) R.drawable.ic_favorit_fill else R.drawable.ic_favorit
//
//
//    val coroutineScope = rememberCoroutineScope()
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//        SmallAngledButton(
//            onClick = {
//                isSelected = !isSelected
//                if (isSelected) {
//                    coroutineScope.launch {
//                        orbOffset.animateTo(0f)
//                        imageScale.animateTo(0.4f, tween(300, easing = LinearEasing))
//                        imageRotation.animateTo(-30f, tween(300, easing = LinearEasing))
//                        coroutineScope.launch {
//                            delay(300)
//                            orbOffset.animateTo(orbOffset.value.minus(50f), tween(600))
//                        }
//                    }
//
//                    coroutineScope.launch {
//                        orbScale.animateTo(1f)
//                        imageScale.animateTo(1f)
//                        imageRotation.animateTo(0f)
//                    }
//
//                    coroutineScope.launch {
//                        delay(600)
//                        orbScale.animateTo(0f, tween(300))
//                    }
//
//                } else {
//                    coroutineScope.launch {
//                        imageScale.animateTo(1f)
//                        imageRotation.animateTo(0f)
//                        orbOffset.animateTo(0f)
//                        orbScale.animateTo(0f)
//                    }
//                }
//
//            },
//            contentColor = Primary,
//            shape = CircleShape,
//            modifier = Modifier
//                .size(smallIconSize)
//                .padding(space4)
//        ) {
//            Icon(
//                painter = painterResource(id = favoriteIcon),
//                contentDescription = null,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .scale(imageScale.value)
//                    .rotate(imageRotation.value)
//            )
//        }
//    }
//
//}
//
//private suspend fun x(
//    coroutineScope: CoroutineScope,
//    imageScale: Animatable<Float, AnimationVector1D>,
//    imageRotation: Animatable<Float, AnimationVector1D>,
//    orbOffset: Animatable<Float, AnimationVector1D>,
//    orbScale: Animatable<Float, AnimationVector1D>
//) {
//    orbOffset.animateTo(0f)
//    imageScale.animateTo(0.4f, tween(300, easing = LinearEasing))
//    imageRotation.animateTo(-30f, tween(300, easing = LinearEasing))
//
//    delay(300)
//    orbOffset.animateTo(orbOffset.value.minus(50f), tween(600))
//
//    orbScale.animateTo(1f)
//    imageScale.animateTo(1f)
//    imageRotation.animateTo(0f)
//
//
//
//    coroutineScope.launch {
//        delay(600)
//        orbScale.animateTo(0f, tween(300))
//    }
//}