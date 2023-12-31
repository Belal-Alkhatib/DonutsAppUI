package com.uog.donutsuiapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.composables.AngledButton
import com.uog.donutsuiapp.ui.composables.LikeAnimation
import com.uog.donutsuiapp.ui.composables.RotationContent
import com.uog.donutsuiapp.ui.composables.SmallAngledButton
import com.uog.donutsuiapp.ui.composables.SpacerVertical
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.Tertiary
import com.uog.donutsuiapp.ui.theme.TextPrimary
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.largeIconSize
import com.uog.donutsuiapp.ui.theme.radius16
import com.uog.donutsuiapp.ui.theme.radius40
import com.uog.donutsuiapp.ui.theme.radius8
import com.uog.donutsuiapp.ui.theme.space10
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space18
import com.uog.donutsuiapp.ui.theme.space24
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.space8
import com.uog.donutsuiapp.ui.theme.textLetterSpacing8
import com.uog.donutsuiapp.ui.theme.textSize22
import com.uog.donutsuiapp.ui.theme.typography

@Composable
fun DetailsScreen(
    navController: NavController
) {
    DetailsContent(
        onBackButtonClicked = { navController.popBackStack() }
    )
}

@Composable
private fun DetailsContent(
    onBackButtonClicked: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Tertiary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = null,
            modifier = Modifier
                .padding(top = space24, start = space24)
                .clickable { onBackButtonClicked() }

        )
        RotationContent(startScale = true, modifier = Modifier.weight(1.5f)) {

            Image(
                painter = painterResource(id = R.drawable.ic_big_donut),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center
            )
        }

        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {

            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(topStart = radius40, topEnd = radius40)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = space24)
                ) {

                    Text(
                        text = stringResource(R.string.strawberry_wheel),
                        style = typography.headlineMedium,
                        color = Primary,
                        modifier = Modifier.padding(top = space24)
                    )


                    Text(
                        text = stringResource(R.string.about_gonut),
                        style = typography.titleMedium,
                        color = TextPrimary,
                        modifier = Modifier.padding(top = space24)
                    )

                    Text(
                        text = stringResource(R.string.about_gonut_desc),
                        style = typography.bodySmall.copy(letterSpacing = textLetterSpacing8),
                        color = TextSecondary,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = space16)
                    )

                    Text(
                        text = stringResource(R.string.quantity),
                        style = typography.titleMedium,
                        color = TextPrimary,
                        modifier = Modifier.padding(top = space24)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = space16),
                        horizontalArrangement = Arrangement.spacedBy(space8)
                    ) {
                        SmallAngledButton(onClick = {}) {
                            Text(
                                text = stringResource(R.string.minus),
                                style = typography.labelLarge,
                                color = Black,
                                textAlign = TextAlign.Center,
                            )
                        }

                        SmallAngledButton(onClick = {}) {
                            Text(
                                text = stringResource(R.string.one),
                                style = typography.labelLarge,
                                fontSize = textSize22,
                                color = Black,
                                textAlign = TextAlign.Center,
                            )
                        }

                        SmallAngledButton(onClick = {}, containerColor = Black) {
                            Text(
                                text = stringResource(R.string.plus),
                                style = typography.labelLarge,
                                modifier = Modifier.fillMaxHeight(),
                                color = White,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(0.2f))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(space16),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.price16),
                            style = typography.headlineMedium,
                            color = Black,
                            textAlign = TextAlign.Center
                        )

                        AngledButton(
                            title = stringResource(R.string.add_to_card),
                            onClick = { },
                            containerColor = Primary,
                            contentColor = White,
                            modifier = Modifier.fillMaxWidth()
                        )


                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                }

            }

            LikeAnimation(
                buttonShape = RoundedCornerShape(radius8), modifier = Modifier
                    .padding(end = space40)
                    .align(Alignment.TopEnd)
                    .offset(y = (-space18)),
                buttonSize = largeIconSize
            )
            SpacerVertical(space = space16)
        }


    }

}

@Preview
@Composable
fun DetailsContentPrev() {
    DetailsContent({})
}
