package com.adematici.customtheme.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Red = Color(0xFFFF0000)
val Red2x = Color(0xFF8D0000)
val Pink = Color(0xFFFFC0CB)
val Pink2x = Color(0xFFFF92A5)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Yellow = Color(0xFFFFFF00)
val Yellow2x = Color(0xFFB9B900)
val Blue = Color(0xFF0000FF)
val Blue2x = Color(0xFF0000A3)
val Orange = Color(0xFFFFA500)
val Orange2x = Color(0xFFBB7900)
val Green = Color(0xFF00FF00)
val Green2x = Color(0xFF008B00)

fun customLightColors() = ThemePalette(
    primary = Red,
    primaryVariant = Pink,
    secondary = White,
    secondaryVariant = Black,
    textPrimary = Yellow,
    textSecondary = Blue,
    background = Orange,
    surface = Green,
    error = Red,
    onPrimary = Pink,
    onSecondary = White,
    onBackground = Black,
    onSurface = Yellow,
    onError = Blue,
)

fun customDarkColors() = ThemePalette(
    primary = Red2x,
    primaryVariant = Pink2x,
    secondary = White,
    secondaryVariant = Black,
    textPrimary = Yellow2x,
    textSecondary = Blue2x,
    background = Orange2x,
    surface = Green2x,
    error = Red2x,
    onPrimary = Pink2x,
    onSecondary = White,
    onBackground = Black,
    onSurface = Yellow2x,
    onError = Blue2x,
)

internal val LocalThemePalette = staticCompositionLocalOf { customLightColors() }

class ThemePalette(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    textPrimary: Color,
    textSecondary: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var error by mutableStateOf(error)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onError by mutableStateOf(onError)
        private set

    fun updateColors(palette: ThemePalette) {
        primary = palette.primary
        primaryVariant = palette.primaryVariant
        secondary = palette.secondary
        secondaryVariant = palette.secondaryVariant
        textPrimary = palette.textPrimary
        textSecondary = palette.textSecondary
        background = palette.background
        surface = palette.surface
        error = palette.error
        onPrimary = palette.onPrimary
        onSecondary = palette.onSecondary
        onBackground = palette.onBackground
        onSurface = palette.onSurface
        onError = palette.onError
        error = palette.error
    }

}