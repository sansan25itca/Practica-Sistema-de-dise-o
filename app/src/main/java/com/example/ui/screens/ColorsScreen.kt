package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.EducationalBanner
import com.example.ui.components.TokenBadge
import com.example.ui.theme.ColorOnSuccessDark
import com.example.ui.theme.ColorOnSuccessLight
import com.example.ui.theme.ColorSuccessDark
import com.example.ui.theme.ColorSuccessLight
import com.example.ui.theme.toHex

data class ColorTokenItem(
    val name: String,
    val color: Color,
    val onColor: Color,
    val role: String
)

data class ColorCategoryGroup(
    val categoryName: String,
    val description: String,
    val tokens: List<ColorTokenItem>
)

@Composable
fun ColorsScreen(modifier: Modifier = Modifier) {
    val colorScheme = MaterialTheme.colorScheme
    val isDark = colorScheme.background.red < 0.5f

    val successColor = if (isDark) ColorSuccessDark else ColorSuccessLight
    val onSuccessColor = if (isDark) ColorOnSuccessDark else ColorOnSuccessLight

    val groups = listOf(
        ColorCategoryGroup(
            categoryName = "Primary (Color Primario)",
            description = "El color de mayor jerarquía en la app. Usado en botones clave, FABs e indicadores activos.",
            tokens = listOf(
                ColorTokenItem("Primary", colorScheme.primary, colorScheme.onPrimary, "Acciones principales y elementos activos"),
                ColorTokenItem("On Primary", colorScheme.onPrimary, colorScheme.primary, "Texto e iconos sobre el color primario"),
                ColorTokenItem("Primary Container", colorScheme.primaryContainer, colorScheme.onPrimaryContainer, "Contenedores con énfasis medio"),
                ColorTokenItem("On Primary Container", colorScheme.onPrimaryContainer, colorScheme.primaryContainer, "Texto sobre el contenedor primario")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Secondary (Color Secundario)",
            description = "Menos prominente que el primario. Usado en chips, filtros y controles complementarios.",
            tokens = listOf(
                ColorTokenItem("Secondary", colorScheme.secondary, colorScheme.onSecondary, "Acciones y destacados secundarios"),
                ColorTokenItem("On Secondary", colorScheme.onSecondary, colorScheme.secondary, "Texto e iconos sobre secundario"),
                ColorTokenItem("Secondary Container", colorScheme.secondaryContainer, colorScheme.onSecondaryContainer, "Contenedores de chips y filtros"),
                ColorTokenItem("On Secondary Container", colorScheme.onSecondaryContainer, colorScheme.secondaryContainer, "Texto en contenedores secundarios")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Tertiary (Color Terciario)",
            description = "Proporciona acentos equilibrados y contraste con los tonos primarios y secundarios.",
            tokens = listOf(
                ColorTokenItem("Tertiary", colorScheme.tertiary, colorScheme.onTertiary, "Acentos cromáticos y alertas suaves"),
                ColorTokenItem("On Tertiary", colorScheme.onTertiary, colorScheme.tertiary, "Texto sobre terciario"),
                ColorTokenItem("Tertiary Container", colorScheme.tertiaryContainer, colorScheme.onTertiaryContainer, "Contenedores con matiz distintivo"),
                ColorTokenItem("On Tertiary Container", colorScheme.onTertiaryContainer, colorScheme.tertiaryContainer, "Texto sobre contenedor terciario")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Background (Fondo General)",
            description = "El lienzo base detrás de todo el contenido desplazable.",
            tokens = listOf(
                ColorTokenItem("Background", colorScheme.background, colorScheme.onBackground, "Lienzo de fondo de la pantalla"),
                ColorTokenItem("On Background", colorScheme.onBackground, colorScheme.background, "Texto general de lectura y titulares")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Surface (Superficies y Tarjetas)",
            description = "Colores para elementos con elevación como tarjetas, hojas inferiores y barras de navegación.",
            tokens = listOf(
                ColorTokenItem("Surface", colorScheme.surface, colorScheme.onSurface, "Superficie base de tarjetas y diálogos"),
                ColorTokenItem("On Surface", colorScheme.onSurface, colorScheme.surface, "Texto e iconos sobre tarjetas"),
                ColorTokenItem("Surface Variant", colorScheme.surfaceVariant, colorScheme.onSurfaceVariant, "Superficie de contraste sutil"),
                ColorTokenItem("Outline", colorScheme.outline, colorScheme.surface, "Líneas de borde de campos y separadores")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Error (Estados de Alerta)",
            description = "Indica errores críticos, campos inválidos o acciones destructivas.",
            tokens = listOf(
                ColorTokenItem("Error", colorScheme.error, colorScheme.onError, "Estados de fallo y advertencia"),
                ColorTokenItem("On Error", colorScheme.onError, colorScheme.error, "Texto legible sobre fondo de error"),
                ColorTokenItem("Error Container", colorScheme.errorContainer, colorScheme.onErrorContainer, "Fondos suaves para mensajes de error"),
                ColorTokenItem("On Error Container", colorScheme.onErrorContainer, colorScheme.errorContainer, "Texto de advertencias en contenedores")
            )
        ),
        ColorCategoryGroup(
            categoryName = "Success (Estados de Éxito)",
            description = "Indica confirmación, tareas completadas y estados positivos.",
            tokens = listOf(
                ColorTokenItem("Success", successColor, onSuccessColor, "Acciones exitosas y marcas positivas"),
                ColorTokenItem("On Success", onSuccessColor, successColor, "Texto e iconos sobre fondo de éxito")
            )
        )
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("colors_screen")
    ) {
        item {
            EducationalBanner(
                title = "Fundamento: Sistema de Color M3",
                description = "Los sistemas de diseño modernos no usan colores aislados o valores hexadecimales fijos, sino pares semánticos (por ejemplo, 'Primary' y 'On Primary'). Esto garantiza un contraste accesible (mínimo 4.5:1 según WCAG) tanto en modo claro como en modo oscuro."
            )
        }

        groups.forEach { group ->
            item {
                Column(modifier = Modifier.padding(top = 4.dp)) {
                    Text(
                        text = group.categoryName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = group.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            group.tokens.forEachIndexed { index, token ->
                                ColorSwatchRow(token = token)
                                if (index < group.tokens.size - 1) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ColorSwatchRow(
    token: ColorTokenItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f),
                RoundedCornerShape(8.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Color preview square with on-color text inside
        Box(
            modifier = Modifier
                .size(width = 72.dp, height = 48.dp)
                .background(token.color, RoundedCornerShape(8.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Aa",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = token.onColor
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = token.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = token.role,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        TokenBadge(
            text = token.color.toHex(),
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        )
    }
}
