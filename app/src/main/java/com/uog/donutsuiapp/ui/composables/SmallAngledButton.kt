package com.uog.donutsuiapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Primary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.buttonSmallHeight
import com.uog.donutsuiapp.ui.theme.radius16
import com.uog.donutsuiapp.ui.theme.space2
import com.uog.donutsuiapp.ui.theme.space4
import com.uog.donutsuiapp.ui.theme.typography

@Composable
fun SmallAngledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    containerColor: Color = White,
    contentColor: Color = Black,
    content: @Composable() () -> Unit

) {
    FloatingActionButton(
        modifier = modifier
            .size(buttonSmallHeight),
        onClick = { onClick() },
        containerColor = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(radius16),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = space4)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(space4),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Preview()
@Composable
fun test2() {
    SmallAngledButton(onClick = {}) {
        Text(
            text = "1",
            style = typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        //Image(painter = painterResource(id = R.drawable.ic_favorit), contentDescription = null, modifier = Modifier.fillMaxSize())
    }
}