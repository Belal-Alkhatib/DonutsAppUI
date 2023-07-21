package com.uog.donutsuiapp.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uog.donutsuiapp.R
import com.uog.donutsuiapp.ui.theme.Black
import com.uog.donutsuiapp.ui.theme.Secondary
import com.uog.donutsuiapp.ui.theme.Tertiary
import com.uog.donutsuiapp.ui.theme.White
import com.uog.donutsuiapp.ui.theme.buttonHeight
import com.uog.donutsuiapp.ui.theme.typography

@Composable
fun AngledButton(modifier:Modifier = Modifier, title: String, onClick: () -> Unit, containerColor: Color = White, contentColor: Color = Black) {
    Button(
        modifier = modifier.height(buttonHeight),
        onClick = { onClick ()},
        colors = ButtonDefaults.buttonColors(containerColor = containerColor, contentColor = contentColor)

    ) {
        Text(text = title, style = typography.titleLarge)
    }
}