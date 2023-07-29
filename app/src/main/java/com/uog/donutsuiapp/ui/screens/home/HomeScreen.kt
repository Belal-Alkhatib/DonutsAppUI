package com.uog.donutsuiapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.navigation.Screen
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
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.space8
import com.uog.donutsuiapp.ui.theme.typography

@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeContent(onTodayOfferCardClicked = { navController.navigate(Screen.DetailsScreen.rout) })
}

@Composable
private fun HomeContent(
    onTodayOfferCardClicked: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),

    ) {

        item { HeaderSection() }
        item {
            TodayOffersSection(
                //modifier = Modifier.weight(3f),
                onTodayOfferCardClicked = { onTodayOfferCardClicked })
        }
        item{
            SmallDonutsCardsSection()
        }







    }
}

@Composable
private fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = space16, horizontal = space24),
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

        SmallAngledButton(onClick = { }, containerColor = Tertiary) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                tint = Primary
            )
        }
    }
}

@Composable
private fun TodayOffersSection(modifier: Modifier = Modifier, onTodayOfferCardClicked: () -> Unit) {
    Text(
        text = stringResource(R.string.today_offers),
        style = typography.titleLarge,
        color = Black,
        modifier = Modifier.padding(start = space24)
    )

    LazyRow(
        modifier = modifier.clipToBounds(),
        horizontalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(start = space40)
    ) {
        items(3) {
            TodayOfferCard(
                modifier = Modifier.padding(bottom = space40),
                containerColor = if (it % 2 == 0) Tertiary else Blue,
                donutName = stringResource(id = R.string.strawberry_wheel),
                imageRes = R.drawable.ic_medium_donut1,
                donutDescription = stringResource(R.string.donut_escription),
                previousPrice = stringResource(R.string._20),
                currentPrice = stringResource(R.string._16),
                onCardClicked = { onTodayOfferCardClicked() })
        }
    }
}

@Composable
private fun SmallDonutsCardsSection() {
    Text(
        text = stringResource(R.string.donuts),
        style = typography.titleLarge,
        color = Black,
        modifier = Modifier.padding(bottom = space40, start = space24)
    )

    LazyRow(
        //modifier = Modifier.weight(1f),
        contentPadding = PaddingValues(start = space40),
        horizontalArrangement = Arrangement.spacedBy(space16)
    ) {
        items(3) {
            DonutsCard(
                modifier = Modifier.padding(bottom = space40),
                containerColor = White,
                donutName = stringResource(R.string.chocolate_cherry),
                imageRes = R.drawable.ic_small_donut3,
                price = stringResource(R.string._22),
            )
        }
    }
}