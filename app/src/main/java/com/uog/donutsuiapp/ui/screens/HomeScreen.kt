package com.uog.donutsuiapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.composables.DonutsCard
import com.uog.donutsuiapp.ui.composables.SmallAngledButton
import com.uog.donutsuiapp.ui.composables.TodayOfferCard
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Blue
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.Tertiary
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space24
import com.uog.donutsuiapp.ui.theme.typography

@Preview
@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
private fun HomeContent() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(vertical = space16, horizontal = space24),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = stringResource(R.string.lets_gonuts),
                    style = typography.headlineMedium,
                    color = Primary,
                )

                Text(
                    text = stringResource(R.string.order_your_favorit),
                    style = typography.bodyMedium,
                    color = TextSecondary,
                    textAlign = TextAlign.Start,

                )
            }

            SmallAngledButton(onClick = { }, contentColor = Primary, containerColor = Tertiary) {
                Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            }
        }


        Text(
            text = stringResource(R.string.today_offers),
            style = typography.titleLarge,
            color = Black,
            modifier = Modifier.padding(bottom = space16, start = space24)
        )

        LazyRow(modifier = Modifier.weight(3f).clipToBounds().padding(start = space24)){
            items(3){
                TodayOfferCard(
                    containerColor = if (it % 2 == 0) Tertiary else Blue,
                    donutName = "Strawberry Wheel",
                    imageRes = R.drawable.ic_medium_donut1,
                    donutDescription = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                    previousPrice = "$20",
                    currentPrice = "$16"
                )
            }
        }

        Text(
            text = stringResource(R.string.donuts),
            style = typography.titleLarge,
            color = Black,
            modifier = Modifier.padding(bottom = space16, start = space24)
        )

        LazyRow(modifier = Modifier.weight(1f).padding(start = space24), horizontalArrangement = Arrangement.spacedBy(space16)){
            items(3){
                DonutsCard(
                    containerColor = if (it % 2 == 0) Tertiary else Blue,
                    donutName = "Chocolate Cherry",
                    imageRes = R.drawable.ic_small_donut1,
                    price = "$22",
                )
            }
        }

        Spacer(modifier = Modifier.weight(0.33f))

    }
}