package com.jk.udemyapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class Im

@Composable
fun Image() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        content = {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
    )
}

@Composable
fun RoundedCornerColorBox(color: Color) {
    ColorBox(shape = RoundedCornerShape(10.dp), color = color)
}

@Composable
fun ColorBox(shape: Shape, color: Color) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(shape)
            .background(color)
    )
}
