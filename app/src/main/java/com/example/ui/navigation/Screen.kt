package com.example.ui.navigation

sealed class Screen(val route: String, val title: String) {
    // Bottom Bar Destinations
    object Home : Screen("home", "Inicio")
    object Components : Screen("components", "Componentes")
    object Settings : Screen("settings", "Ajustes")

    // Design System Pillar Detail Screens
    object Typography : Screen("typography", "Tipografía")
    object Colors : Screen("colors", "Colores")
    object Themes : Screen("themes", "Temas")
    object Icons : Screen("icons", "Iconos")
    object Animations : Screen("animations", "Animaciones")
    object Shapes : Screen("shapes", "Bordes y Esquinas")
    object Spacing : Screen("spacing", "Espaciado")
}
