package com.example.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ui.components.AppTopBar
import com.example.ui.components.BottomNavBar
import com.example.ui.screens.AnimationsScreen
import com.example.ui.screens.ColorsScreen
import com.example.ui.screens.ComponentsScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.IconsScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.ShapesScreen
import com.example.ui.screens.SpacingScreen
import com.example.ui.screens.ThemesScreen
import com.example.ui.screens.TypographyScreen
import com.example.ui.theme.ThemeMode
import com.example.viewmodel.DesignSystemViewModel

@Composable
fun AppNavigation(
    viewModel: DesignSystemViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route
    val themeMode by viewModel.themeMode.collectAsState()

    val isRootTab = currentRoute == Screen.Home.route ||
            currentRoute == Screen.Components.route ||
            currentRoute == Screen.Settings.route

    val screenTitle = when (currentRoute) {
        Screen.Home.route -> "Design System Explorer"
        Screen.Components.route -> "Componentes M3"
        Screen.Settings.route -> "Ajustes y Principios"
        Screen.Typography.route -> "Tipografía"
        Screen.Colors.route -> "Paleta de Colores"
        Screen.Themes.route -> "Temas Claro y Oscuro"
        Screen.Icons.route -> "Iconos Vectoriales"
        Screen.Animations.route -> "Animaciones y Transiciones"
        Screen.Shapes.route -> "Bordes y Esquinas"
        Screen.Spacing.route -> "Sistema de Espaciado"
        else -> "Design System"
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = screenTitle,
                canNavigateBack = !isRootTab,
                onNavigateBack = { navController.popBackStack() },
                currentThemeMode = themeMode,
                onToggleTheme = {
                    val nextMode = if (themeMode == ThemeMode.DARK) ThemeMode.LIGHT else ThemeMode.DARK
                    viewModel.setThemeMode(nextMode)
                }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onNavigateToRoute = { route ->
                    navController.navigate(route) {
                        popUpTo(Screen.Home.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Root Tab 1: Home
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToSection = { targetScreen ->
                        navController.navigate(targetScreen.route)
                    }
                )
            }

            // Root Tab 2: Components
            composable(Screen.Components.route) {
                ComponentsScreen()
            }

            // Root Tab 3: Settings
            composable(Screen.Settings.route) {
                SettingsScreen(viewModel = viewModel)
            }

            // Pillar 1: Typography
            composable(Screen.Typography.route) {
                TypographyScreen(viewModel = viewModel)
            }

            // Pillar 2: Colors
            composable(Screen.Colors.route) {
                ColorsScreen()
            }

            // Pillar 3: Themes
            composable(Screen.Themes.route) {
                ThemesScreen(viewModel = viewModel)
            }

            // Pillar 4: Icons
            composable(Screen.Icons.route) {
                IconsScreen(viewModel = viewModel)
            }

            // Pillar 5: Animations
            composable(Screen.Animations.route) {
                AnimationsScreen(viewModel = viewModel)
            }

            // Pillar 6: Shapes
            composable(Screen.Shapes.route) {
                ShapesScreen(viewModel = viewModel)
            }

            // Pillar 7: Spacing
            composable(Screen.Spacing.route) {
                SpacingScreen(viewModel = viewModel)
            }
        }
    }
}
