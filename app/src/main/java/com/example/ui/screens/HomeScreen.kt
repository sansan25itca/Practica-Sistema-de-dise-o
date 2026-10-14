package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.AspectRatio
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.FormatPaint
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.SectionCard
import com.example.ui.navigation.Screen

data class DesignSectionItem(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val tint: Color,
    val bg: Color,
    val badge: String,
    val screen: Screen
)

@Composable
fun HomeScreen(
    onNavigateToSection: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val sections = listOf(
        DesignSectionItem(
            title = "Tipografía",
            description = "Jerarquía de texto, escalas tipográficas y grosores en sp.",
            icon = Icons.Default.TextFields,
            tint = Color(0xFF3F51B5),
            bg = Color(0xFFE8EAF6),
            badge = "15 Estilos",
            screen = Screen.Typography
        ),
        DesignSectionItem(
            title = "Colores",
            description = "Tokens semánticos de Material 3, contraste y códigos HEX.",
            icon = Icons.Default.ColorLens,
            tint = Color(0xFF00897B),
            bg = Color(0xFFE0F2F1),
            badge = "Paleta M3",
            screen = Screen.Colors
        ),
        DesignSectionItem(
            title = "Temas",
            description = "Conmutación en tiempo real entre temas Claro y Oscuro.",
            icon = Icons.Default.DarkMode,
            tint = Color(0xFF6A1B9A),
            bg = Color(0xFFF3E5F5),
            badge = "Claro/Oscuro",
            screen = Screen.Themes
        ),
        DesignSectionItem(
            title = "Iconos",
            description = "Símbolos vectoriales universales, tamaños y accesibilidad.",
            icon = Icons.Default.FormatPaint,
            tint = Color(0xFFE65100),
            bg = Color(0xFFFFF3E0),
            badge = "Vectores",
            screen = Screen.Icons
        ),
        DesignSectionItem(
            title = "Animaciones",
            description = "Transiciones suaves, microinteracciones y cambios de estado.",
            icon = Icons.Default.Animation,
            tint = Color(0xFFD81B60),
            bg = Color(0xFFFCE4EC),
            badge = "Compose Motion",
            screen = Screen.Animations
        ),
        DesignSectionItem(
            title = "Bordes y Esquinas",
            description = "Radios de redondeo (0 a 28 dp) y estilos de contorno.",
            icon = Icons.Default.CropSquare,
            tint = Color(0xFF0277BD),
            bg = Color(0xFFE1F5FE),
            badge = "Shapes",
            screen = Screen.Shapes
        ),
        DesignSectionItem(
            title = "Espaciado",
            description = "Sistema modular de 8 dp, padding, márgenes y alineación.",
            icon = Icons.Default.AspectRatio,
            tint = Color(0xFF2E7D32),
            bg = Color(0xFFE8F5E9),
            badge = "Grilla 8dp",
            screen = Screen.Spacing
        )
    )

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val columns = if (maxWidth > 600.dp) 2 else 1

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .testTag("home_screen_grid")
        ) {
            // Header Section
            item(span = { GridItemSpan(columns) }) {
                Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                    Text(
                        text = "Design System Explorer",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Explora los fundamentos del diseño de interfaces",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Educational Hero Card
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .background(MaterialTheme.colorScheme.primary, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.MenuBook,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.onPrimary,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "¿Qué es un Sistema de Diseño?",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "Un conjunto de estándares, tokens y componentes reutilizables.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                QuickStatPill(
                                    label = "7 Fundamentos",
                                    icon = Icons.Default.GridView
                                )
                                QuickStatPill(
                                    label = "Material Design 3",
                                    icon = Icons.Default.CropSquare
                                )
                                QuickStatPill(
                                    label = "Jetpack Compose",
                                    icon = Icons.Default.Animation
                                )
                            }
                        }
                    }
                }
            }

            // Grid Items
            items(sections) { item ->
                SectionCard(
                    title = item.title,
                    description = item.description,
                    icon = item.icon,
                    iconTint = item.tint,
                    iconBgColor = item.bg,
                    categoryBadge = item.badge,
                    onClick = { onNavigateToSection(item.screen) }
                )
            }

            // Academic footer spacer
            item(span = { GridItemSpan(columns) }) {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun QuickStatPill(
    label: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(14.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
