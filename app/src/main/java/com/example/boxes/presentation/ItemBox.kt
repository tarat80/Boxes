package com.example.boxes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ItemBox(
    modifier: Modifier = Modifier,
    /* box: Box*/
) {
    Card(
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = 15.dp, SolidColor(Color.Green),
                RoundedCornerShape(33.dp)),
                        backgroundColor=Color.Green.copy(0.1f)
            )

     {

    }
}