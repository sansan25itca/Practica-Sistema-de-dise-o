package com.example.ui.theme

import androidx.compose.ui.graphics.Color

// Light Theme Palette (Material 3)
val md_theme_light_primary = Color(0xFF3F51B5)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFDEE0FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001159)

val md_theme_light_secondary = Color(0xFF006A6A)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFF6FF7F6)
val md_theme_light_onSecondaryContainer = Color(0xFF002020)

val md_theme_light_tertiary = Color(0xFF7E525E)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFD9E2)
val md_theme_light_onTertiaryContainer = Color(0xFF31101C)

val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onErrorContainer = Color(0xFF410002)

val md_theme_light_background = Color(0xFFFBF8FD)
val md_theme_light_onBackground = Color(0xFF1B1B1F)
val md_theme_light_surface = Color(0xFFFBF8FD)
val md_theme_light_onSurface = Color(0xFF1B1B1F)
val md_theme_light_surfaceVariant = Color(0xFFE3E1EC)
val md_theme_light_onSurfaceVariant = Color(0xFF46464F)
val md_theme_light_outline = Color(0xFF777680)
val md_theme_light_outlineVariant = Color(0xFFC7C5D0)

// Semantic Success Token (Light)
val ColorSuccessLight = Color(0xFF2E7D32)
val ColorOnSuccessLight = Color(0xFFFFFFFF)
val ColorSuccessContainerLight = Color(0xFFC8E6C9)
val ColorOnSuccessContainerLight = Color(0xFF00390E)

// Dark Theme Palette (Material 3)
val md_theme_dark_primary = Color(0xFFB9C3FF)
val md_theme_dark_onPrimary = Color(0xFF041E80)
val md_theme_dark_primaryContainer = Color(0xFF25379C)
val md_theme_dark_onPrimaryContainer = Color(0xFFDEE0FF)

val md_theme_dark_secondary = Color(0xFF4DDADA)
val md_theme_dark_onSecondary = Color(0xFF003737)
val md_theme_dark_secondaryContainer = Color(0xFF004F4F)
val md_theme_dark_onSecondaryContainer = Color(0xFF6FF7F6)

val md_theme_dark_tertiary = Color(0xFFF0B8C5)
val md_theme_dark_onTertiary = Color(0xFF492530)
val md_theme_dark_tertiaryContainer = Color(0xFF633B47)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD9E2)

val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)

val md_theme_dark_background = Color(0xFF121316)
val md_theme_dark_onBackground = Color(0xFFE4E1E6)
val md_theme_dark_surface = Color(0xFF121316)
val md_theme_dark_onSurface = Color(0xFFE4E1E6)
val md_theme_dark_surfaceVariant = Color(0xFF46464F)
val md_theme_dark_onSurfaceVariant = Color(0xFFC7C5D0)
val md_theme_dark_outline = Color(0xFF91909A)
val md_theme_dark_outlineVariant = Color(0xFF46464F)

// Semantic Success Token (Dark)
val ColorSuccessDark = Color(0xFF81C784)
val ColorOnSuccessDark = Color(0xFF00390E)
val ColorSuccessContainerDark = Color(0xFF1B5E20)
val ColorOnSuccessContainerDark = Color(0xFFC8E6C9)

// Helper to convert Color to HEX string
fun Color.toHex(): String {
    val a = (alpha * 255).toInt()
    val r = (red * 255).toInt()
    val g = (green * 255).toInt()
    val b = (blue * 255).toInt()
    return if (a == 255) {
        String.format("#%02X%02X%02X", r, g, b)
    } else {
        String.format("#%02X%02X%02X%02X", a, r, g, b)
    }
}
