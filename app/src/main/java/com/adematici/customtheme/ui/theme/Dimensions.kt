package com.adematici.customtheme.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DimensionsPalette(
    val paddingSmall: Dp = 6.dp,
    val paddingMedium: Dp = 12.dp,
    val paddingLarge: Dp = 24.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { DimensionsPalette() }