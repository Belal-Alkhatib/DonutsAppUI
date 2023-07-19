package com.uog.donutsuiapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.TextSecondary
import com.uog.donutsuiapp.ui.theme.space16
import com.uog.donutsuiapp.ui.theme.space4
import com.uog.donutsuiapp.ui.theme.typography

@Composable
fun DiscountPrice(modifier: Modifier = Modifier, previousPrice: String, currentPrice: String) {
    Row(
        modifier = modifier
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