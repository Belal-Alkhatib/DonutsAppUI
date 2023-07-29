package com.uog.donutsuiapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.navigation.Screen
import com.uog.donutsuiapp.ui.composables.AngledButton
import com.uog.donutsuiapp.ui.composables.SpacerVertical
import com.uog.donutsuiapp.ui.composables.setStatusBarColor
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.Secondary
import com.uog.donutsuiapp.ui.theme.Tertiary
import com.uog.donutsuiapp.ui.theme.space24
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.typography


@Composable
fun WelcomeScreen(
    navController: NavHostController,
) {
    WelcomeContent(
        onGetStatingClicked = { navController.navigate(Screen.HomeScreen.rout)}
    )
    val systemUIController = rememberSystemUiController()
    LaunchedEffect(true) {
        setStatusBarColor(
            systemUIController = systemUIController,
            color = Tertiary,
        )
    }
}


@Composable
private fun WelcomeContent(
    onGetStatingClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Tertiary)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.border_donuts),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Inside
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(horizontal = space40).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = stringResource(R.string.gonuts_with_donuts),
                    style = typography.headlineLarge,
                    color = Primary,
                )

                Text(
                    text = stringResource(R.string.gonuts_with_donuts_desc),
                    style = typography.bodyLarge,
                    color = Secondary,
                )

                AngledButton(
                    title = stringResource(R.string.get_started),
                    onClick = { onGetStatingClicked() },
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }

        SpacerVertical(space = space24)


    }
}