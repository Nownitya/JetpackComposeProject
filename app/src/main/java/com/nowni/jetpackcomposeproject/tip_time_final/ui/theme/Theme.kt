package com.nowni.jetpackcomposeproject.tip_time_final.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_primary,
    onPrimary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onPrimary,
    primaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_primaryContainer,
    onPrimaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onPrimaryContainer,
    secondary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_secondary,
    onSecondary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onSecondary,
    secondaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_secondaryContainer,
    onSecondaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onSecondaryContainer,
    tertiary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_tertiary,
    onTertiary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onTertiary,
    tertiaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_tertiaryContainer,
    onTertiaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onTertiaryContainer,
    error = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_error,
    onError = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onError,
    errorContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_errorContainer,
    onErrorContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onErrorContainer,
    background = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_background,
    onBackground = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onBackground,
    surface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_surface,
    onSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onSurface,
    surfaceVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_surfaceVariant,
    onSurfaceVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_onSurfaceVariant,
    outline = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_outline,
    inverseSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_inverseSurface,
    inverseOnSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_inverseOnSurface,
    inversePrimary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_inversePrimary,
    surfaceTint = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_surfaceTint,
    outlineVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_outlineVariant,
    scrim = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.dark_scrim
)

private val LightColorScheme = lightColorScheme(
    primary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_primary,
    onPrimary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onPrimary,
    primaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_primaryContainer,
    secondary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_secondary,
    onSecondary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onSecondary,
    secondaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_secondaryContainer,
    onSecondaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onSecondaryContainer,
    tertiary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_tertiary,
    onTertiary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onTertiary,
    tertiaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_tertiaryContainer,
    onTertiaryContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onTertiaryContainer,
    error = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_error,
    errorContainer = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_errorContainer,
    background = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_background,
    onBackground = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onBackground,
    surface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_surface,
    surfaceVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_surfaceVariant,
    onSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onSurface,
    onSurfaceVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_onSurfaceVariant,
    outline = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_outline,
    inverseSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_inverseSurface,
    inverseOnSurface = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_inverseOnSurface,
    inversePrimary = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_inversePrimary,
    surfaceTint = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_surfaceTint,
    outlineVariant = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_outlineVariant,
    scrim = com.nowni.jetpackcomposeproject.tip_time_starter.ui.theme.light_scrim
)

@Composable
fun TipTimeFinalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}