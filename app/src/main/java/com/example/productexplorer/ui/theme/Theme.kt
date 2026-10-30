package com.example.productexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006C4C),
    onPrimary = Color.White,
    secondary = Color(0xFF4F6357),
    background = Color(0xFFF7FBF6),
    onBackground = Color(0xFF191C1A),
    surface = Color.White,
    onSurface = Color(0xFF191C1A)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF7DDBB0),
    onPrimary = Color(0xFF003826),
    secondary = Color(0xFFB7CCBC),
    background = Color(0xFF101411),
    onBackground = Color(0xFFE0E4DF),
    surface = Color(0xFF1C211D),
    onSurface = Color(0xFFE0E4DF)
)

@Composable
fun ProductExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )
}
