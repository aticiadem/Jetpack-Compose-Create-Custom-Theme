package com.adematici.customtheme.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ElevationPalette(
    val defaultElevation: Dp = 2.dp,
    val pressedElevation: Dp = 10.dp,
    val disabledElevation: Dp = 0.dp,
)

internal val LocalElevation = staticCompositionLocalOf { ElevationPalette() }