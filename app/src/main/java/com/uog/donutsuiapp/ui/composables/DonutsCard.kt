package com.uog.donutsuiapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Blue
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.cardDonutsHeight
import com.uog.donutsuiapp.ui.theme.radius10
import com.uog.donutsuiapp.ui.theme.radius20
import com.uog.donutsuiapp.ui.theme.space10
import com.uog.donutsuiapp.ui.theme.space4
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.space56
import com.uog.donutsuiapp.ui.theme.space8
import com.uog.donutsuiapp.ui.theme.typography


@Composable
fun DonutsCard(
    donutName: String,
    @DrawableRes imageRes: Int,
    price: String,
    containerColor: Color = White,
    modifier: Modifier = Modifier
) {

    ConstraintLayout(
        modifier = Modifier
            .height(cardDonutsHeight + space56)
            .background(color = White)
    ) {
        val (cardDonuts, imageDonut) = createRefs()

        Card(
            modifier = modifier
                .height(cardDonutsHeight)
                .constrainAs(cardDonuts) {
                    bottom.linkTo(parent.bottom)
                },
            colors = CardDefaults.cardColors(containerColor = containerColor),
            elevation = CardDefaults.elevatedCardElevation( defaultElevation = space8),
            shape = RoundedCornerShape(
                topStart = radius20,
                topEnd = radius20,
                bottomStart = radius10,
                bottomEnd = radius10
            )

        ) {
            Column(
                modifier = Modifier.padding(start = space10, end = space10, bottom = space10),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = donutName,
                    style = typography.bodyMedium,
                    color = TextSecondary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = space40)
                )

                Text(
                    text = price,
                    style = typography.labelSmall,
                    color = Primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(vertical = space4)
                )


            }
        }


        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.width(104.dp).height(112.dp).constrainAs(imageDonut) {
                //top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(cardDonuts.top, (-55).dp)
            },
            contentScale = ContentScale.Crop

        )

    }

    /*
    Card(
        //modifier = modifier.width(cardDonutWidth),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        shape = RoundedCornerShape(
            topStart = radius20,
            topEnd = radius20,
            bottomStart = radius10,
            bottomEnd = radius10
        )

    ) {
        Column(
            modifier = Modifier.padding(start = space10, end = space10, bottom = space10),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center),
                contentScale = ContentScale.Crop

            )


            Text(
                text = donutName,
                style = typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = space4)
            )

            Text(
                text = price,
                style = typography.labelSmall,
                color = Primary,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = space4)
            )


        }
    }

*/
}

@Preview
@Composable
fun PreviewDountsCard() {
    DonutsCard(
        containerColor = Blue,
        donutName = "Chocolate Cherry",
        imageRes = R.drawable.ic_small_donut1,
        price = "$22",
    )

    //ImageWithoutTopBounds(R.drawable.ic_medium_donut1)
}