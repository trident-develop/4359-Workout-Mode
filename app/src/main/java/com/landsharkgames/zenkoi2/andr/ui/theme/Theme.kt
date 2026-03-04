package com.landsharkgames.zenkoi2.andr.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val BeigeColorScheme = lightColorScheme(
    primary = WarmBrown,
    onPrimary = BeigeSurface,
    primaryContainer = WarmBrownContainer,
    onPrimaryContainer = WarmBrownDark,
    secondary = WarmBrownLight,
    onSecondary = BeigeSurface,
    secondaryContainer = BeigeCard,
    onSecondaryContainer = TextDark,
    tertiary = WarmBrownDark,
    onTertiary = BeigeSurface,
    background = BeigeBackground,
    onBackground = TextDark,
    surface = BeigeSurface,
    onSurface = TextDark,
    surfaceVariant = BeigeCard,
    onSurfaceVariant = TextMedium,
    outline = BeigeDivider,
)

@Composable
fun WorkoutModeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = BeigeColorScheme,
        typography = Typography,
        content = content
    )
}
