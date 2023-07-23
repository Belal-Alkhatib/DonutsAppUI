package com.uog.donutsuiapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Blue
import com.uog.donutsuiapp.ui.theme.ShadowColor
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.cardOfferWidth
import com.uog.donutsuiapp.ui.theme.largeDonutHeight
import com.uog.donutsuiapp.ui.theme.largeDonutWidth
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space32
import com.uog.donutsuiapp.ui.theme.space4
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.space8
import com.uog.donutsuiapp.ui.theme.textSize12
import com.uog.donutsuiapp.ui.theme.typography


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodayOfferCard(
    modifier: Modifier = Modifier,
    onCardClicked: () -> Unit,
    donutName: String,
    donutDescription: String,
    @DrawableRes imageRes: Int,
    previousPrice: String,
    currentPrice: String,
    containerColor: Color = Blue
) {

    ConstraintLayout(
        modifier = modifier
            .padding(top = space16)
            .clickable { onCardClicked() }
            .width(cardOfferWidth + space40)
            .background(color = White)
    ) {
        val (cardOffer, imageDonut) = createRefs()

        Card(
            modifier = Modifier
                .width(cardOfferWidth)
                .shadow(elevation = space16, spotColor = ShadowColor)
                .constrainAs(cardOffer) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)

                },
            colors = CardDefaults.cardColors(containerColor = containerColor),
        ) {
            Column(modifier = Modifier.padding(start = space16, top = space16, bottom = space16)) {
                LikeAnimation()

                SpacerVertical(space = 160.dp)
                Text(
                    text = donutName,
                    color = Black,
                    style = typography.titleSmall,
                    modifier = Modifier.padding(top = space4, bottom = space8)
                )

                Text(
                    text = donutDescription,
                    color = TextSecondary,
                    style = typography.bodySmall,
                    fontSize = textSize12,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = space4)
                )

                DiscountPrice(currentPrice = currentPrice, previousPrice = previousPrice)
            }
        }

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .height(largeDonutHeight)
                .width(largeDonutWidth)
                .constrainAs(imageDonut) {
                    top.linkTo(cardOffer.top, space32)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterStart
        )

    }


}

@Preview
@Composable
fun PreviewTodayOfferCard() {
    TodayOfferCard(
        donutName = "Strawberry Wheel",
        imageRes = R.drawable.ic_medium_donut1,
        donutDescription = "These Baked Strawberry Donuts are filled with fresh strawberries...",
        previousPrice = "$20",
        currentPrice = "$16",
        onCardClicked = {}
    )
}