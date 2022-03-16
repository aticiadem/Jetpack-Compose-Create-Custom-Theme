package com.adematici.customtheme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun DefaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun ComposeCustomTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    typography: TypographyPalette = ComposeCustomTheme.typography,
    dimensions: DimensionsPalette = ComposeCustomTheme.dimensions,
    shapes: ShapesPalette = ComposeCustomTheme.shapes,
    elevation: ElevationPalette = ComposeCustomTheme.elevation,
    content: @Composable () -> Unit,
) {
    val colors = remember {
        getThemePalette(
            isDarkModeOn = isDark
        )
    }.apply {
        updateColors(
            getThemePalette(
                isDarkModeOn = isDark
            )
        )
    }

    MaterialTheme(
        colors = debugColors(isDark)
    ) {
        ProvideCustomTheme(
            colors = colors,
            typography = typography,
            dimensions = dimensions,
            shapes = shapes,
            content = content,
            elevation = elevation
        )
    }

}

private fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Black,
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

@Composable
private fun ProvideCustomTheme(
    colors: ThemePalette,
    typography: TypographyPalette,
    dimensions: DimensionsPalette,
    shapes: ShapesPalette,
    elevation: ElevationPalette,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalThemePalette provides colors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography,
        LocalShapes provides shapes,
        LocalElevation provides elevation
    ) {
        content()
    }
}

internal fun getThemePalette(
    isDarkModeOn: Boolean,
) = when {
    isDarkModeOn -> customDarkColors()
    else -> customLightColors()
}

object ComposeCustomTheme {
    val colors: ThemePalette
        @Composable
        @ReadOnlyComposable
        get() = LocalThemePalette.current

    val typography: TypographyPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: DimensionsPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: ShapesPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val elevation: ElevationPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalElevation.current
}