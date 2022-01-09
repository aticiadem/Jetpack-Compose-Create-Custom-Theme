package com.adematici.customtheme.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

data class ShapesPalette(
    val small: Shapes = Shapes(RoundedCornerShape(6.dp)),
    val medium: Shapes = Shapes(RoundedCornerShape(12.dp)),
    val large: Shapes = Shapes(RoundedCornerShape(18.dp)),
    val buttonShape: Shapes = Shapes(
        RoundedCornerShape(
            topStart = 20.dp,
            bottomStart = 20.dp
        )
    ),
)

internal val LocalShapes = staticCompositionLocalOf { ShapesPalette() }