package com.uog.donutsuiapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space40
import com.uog.donutsuiapp.ui.theme.space8

@Composable
fun BottomNavigation() {

    val icons = remember {
        mutableStateOf(
            listOf(
                R.drawable.ic_home,
                R.drawable.ic_heart,
                R.drawable.ic_notification,
                R.drawable.ic_buy,
                R.drawable.ic_user,
            )
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = space40, vertical = space16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(icons.value.size) { index ->
            Icon(
                modifier = Modifier
                    .clickable {}
                    .padding(space8),
                painter = painterResource(id = icons.value[index]),
                contentDescription = "bottom nav icons",
                tint = Primary
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    BottomNavigation()
}