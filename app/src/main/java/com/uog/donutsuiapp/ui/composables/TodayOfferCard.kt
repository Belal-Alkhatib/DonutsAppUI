package com.uog.donutsuiapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FixedScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Blue
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.cardOfferWidth
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space4
import com.uog.donutsuiapp.ui.theme.textSize12
import com.uog.donutsuiapp.ui.theme.typography


@Composable
fun TodayOfferCard(
    donutName: String,
    donutDescription: String,
    @DrawableRes imageRes: Int,
    previousPrice: String,
    currentPrice: String,
    containerColor: Color = Blue
) {


    Row(modifier = Modifier
        .width(cardOfferWidth + 32.dp)
        .background(color = White)) {
        Card(
            modifier = Modifier.width(cardOfferWidth),
            colors = CardDefaults.cardColors(containerColor = containerColor)
        ) {
            Column(modifier = Modifier.padding(start = space16, top = space16, bottom = space16)) {
                SmallAngledButton(
                    onClick = { },
                    contentColor = Primary,
                    shape = CircleShape,
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorit),
                        contentDescription = null
                    )
                }


                Box(modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd).fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize(align = Alignment.Center)
                            .width(362.dp)
                            .height(203.dp),
                        contentScale = ContentScale.Crop

                    )
                }

                Text(
                    text = donutName,
                    color = Black,
                    style = typography.titleSmall,
                    modifier = Modifier.padding(vertical = space4)
                )

                Text(
                    text = donutDescription,
                    color = TextSecondary,
                    style = typography.bodySmall,
                    fontSize = textSize12,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(vertical = space4)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = space4, horizontal = space16),
                    horizontalArrangement = Arrangement.spacedBy(space4, alignment = Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = previousPrice,
                        color = TextSecondary,
                        style = typography.labelSmall.copy(textDecoration = TextDecoration.LineThrough)
                    )

                    Text(
                        text = currentPrice,
                        color = Black,
                        style = typography.labelMedium
                    )
                }
            }
        }


    }


}

@Composable
private fun ImageWithoutTopBounds(@DrawableRes id: Int) {
    val painter = painterResource(id = id)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.wrapContentSize(align = Alignment.BottomCenter, unbounded = true),
        contentScale = FixedScale(1f)
    )
}

@Preview
@Composable
fun testt() {
    TodayOfferCard(
        donutName = "Strawberry Wheel",
        imageRes = R.drawable.ic_medium_donut1,
        donutDescription = "These Baked Strawberry Donuts are filled with fresh strawberries...",
        previousPrice = "$20",
        currentPrice = "$16"
    )

    //ImageWithoutTopBounds(R.drawable.ic_medium_donut1)
}