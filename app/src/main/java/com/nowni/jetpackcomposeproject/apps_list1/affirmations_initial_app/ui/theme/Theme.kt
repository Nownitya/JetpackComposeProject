package com.nowni.jetpackcomposeproject.apps_list1.affirmations_initial_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/*private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    *//* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    *//*
)*/

private val LightColor = lightColorScheme(
    primary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_primary,
    onPrimary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onPrimary,
    primaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_primaryContainer,
    onPrimaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onPrimaryContainer,
    secondary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_secondary,
    onSecondary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onSecondary,
    secondaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_secondaryContainer,
    onSecondaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onSecondaryContainer,
    tertiary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_tertiary,
    onTertiary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onTertiary,
    tertiaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_tertiaryContainer,
    onTertiaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onTertiaryContainer,
    error = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_error,
    errorContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_errorContainer,
    onError = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onError,
    onErrorContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onErrorContainer,
    background = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_background,
    onBackground = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onBackground,
    surface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_surface,
    onSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onSurface,
    surfaceVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_surfaceVariant,
    onSurfaceVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_onSurfaceVariant,
    outline = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_outline,
    inverseOnSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_inverseOnSurface,
    inverseSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_inverseSurface,
    inversePrimary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_inversePrimary,
    surfaceTint = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_surfaceTint,
    outlineVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_outlineVariant,
    scrim = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.light_scrim,
)


private val DarkColor = darkColorScheme(
    primary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_primary,
    onPrimary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onPrimary,
    primaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_primaryContainer,
    onPrimaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onPrimaryContainer,
    secondary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_secondary,
    onSecondary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onSecondary,
    secondaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_secondaryContainer,
    onSecondaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onSecondaryContainer,
    tertiary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_tertiary,
    onTertiary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onTertiary,
    tertiaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_tertiaryContainer,
    onTertiaryContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onTertiaryContainer,
    error = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_error,
    errorContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_errorContainer,
    onError = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onError,
    onErrorContainer = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onErrorContainer,
    background = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_background,
    onBackground = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onBackground,
    surface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_surface,
    onSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onSurface,
    surfaceVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_surfaceVariant,
    onSurfaceVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_onSurfaceVariant,
    outline = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_outline,
    inverseOnSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_inverseOnSurface,
    inverseSurface = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_inverseSurface,
    inversePrimary = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_inversePrimary,
    surfaceTint = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_surfaceTint,
    outlineVariant = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_outlineVariant,
    scrim = com.nowni.jetpackcomposeproject.apps_list1.woof.ui.theme.dark_scrim,
)

@Composable
fun AffirmationsTheme(
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

        darkTheme -> DarkColor
        else -> LightColor
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}