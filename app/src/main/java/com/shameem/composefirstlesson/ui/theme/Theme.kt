package com.shameem.composefirstlesson.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    secondary = Teal200
)

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    secondary = Teal200
)


val MyTypography = Typography()

@Composable
fun ComposeFirstLessonTheme(
darkTheme: Boolean = isSystemInDarkTheme(),
content: @Composable () -> Unit
) {
val colors = if (darkTheme) {
    DarkColorPalette
} else {
    LightColorPalette
}

MaterialTheme(
    colorScheme = colors,
    shapes = shapes,
    typography =MyTypography,
    content = content)

}