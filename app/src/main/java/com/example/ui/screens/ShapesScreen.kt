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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.EducationalBanner
import com.example.ui.components.TokenBadge
import com.example.viewmodel.DesignSystemViewModel
import kotlin.math.roundToInt

data class CornerVariantItem(
    val title: String,
    val dpLabel: String,
    val shape: Shape,
    val description: String
)

data class BorderStrokeItem(
    val title: String,
    val thicknessLabel: String,
    val thickness: Float,
    val color: Color,
    val description: String
)

@Composable
fun ShapesScreen(
    viewModel: DesignSystemViewModel,
    modifier: Modifier = Modifier
) {
    val liveRadius by viewModel.interactiveCornerRadius.collectAsState()
    val liveStroke by viewModel.interactiveStrokeWidth.collectAsState()

    val cornerVariants = listOf(
        CornerVariantItem(
            title = "Sin redondeo (Sharp)",
            dpLabel = "0 dp",
            shape = RectangleShape,
            description = "Estilo técnico, editorial o brutalista. Esquinas rectas y perpendiculares."
        ),
        CornerVariantItem(
            title = "Ligeramente redondeadas (Small)",
            dpLabel = "8 dp",
            shape = RoundedCornerShape(8.dp),
            description = "Estilo sutil estándar para tarjetas de densidad media, campos de texto y menús."
        ),
        CornerVariantItem(
            title = "Muy redondeadas (Large)",
            dpLabel = "24 dp",
            shape = RoundedCornerShape(24.dp),
            description = "Sensación cálida, moderna y táctil. Usado en hojas inferiores y tarjetas hero."
        ),
        CornerVariantItem(
            title = "Forma circular o píldora (Full)",
            dpLabel = "50% / CircleShape",
            shape = CircleShape,
            description = "Ideal para botones de acción flotante (FAB), insignias, avatares y chips de filtro."
        )
    )

    val borderVariants = listOf(
        BorderStrokeItem(
            title = "Borde sutil (Subtle)",
            thicknessLabel = "1 dp",
            thickness = 1f,
            color = MaterialTheme.colorScheme.outlineVariant,
            description = "Delimitación discreta para separar superficies del mismo nivel cromático."
        ),
        BorderStrokeItem(
            title = "Borde estándar (Medium)",
            thicknessLabel = "2 dp",
            thickness = 2f,
            color = MaterialTheme.colorScheme.primary,
            description = "Énfasis de selección para campos activos, tarjetas seleccionadas y bordes primarios."
        ),
        BorderStrokeItem(
            title = "Borde de alto contraste (Heavy)",
            thicknessLabel = "4 dp",
            thickness = 4f,
            color = MaterialTheme.colorScheme.tertiary,
            description = "Destaque visual fuerte para estados de alerta o estilos gráficos de alto impacto."
        )
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("shapes_screen")
    ) {
        item {
            EducationalBanner(
                title = "Fundamento: Geometría, Bordes y Superficies",
                description = "Las esquinas (Corner Radius) y contornos (Borders) transmiten la personalidad del producto digital. Bordes afilados denotan formalidad y precisión, mientras que radios amplios transmiten accesibilidad, amabilidad y dinamismo."
            )
        }

        // Interactive Live Slider Playground
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Laboratorio Interactivo de Formas",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Ajusta los controles deslizantes para ver la mutación del componente en tiempo real:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Live target preview
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(
                                MaterialTheme.colorScheme.surface,
                                RoundedCornerShape(liveRadius.dp)
                            )
                            .border(
                                width = liveStroke.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(liveRadius.dp)
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Radio: ${liveRadius.roundToInt()} dp  |  Borde: ${liveStroke.roundToInt()} dp",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Radius slider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Radio de esquina: ${liveRadius.roundToInt()} dp",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium
                        )
                        TokenBadge(text = "0 a 36 dp")
                    }
                    Slider(
                        value = liveRadius,
                        onValueChange = { viewModel.setCornerRadius(it) },
                        valueRange = 0f..36f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("corner_radius_slider")
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Stroke slider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Grosor de borde: ${liveStroke.roundToInt()} dp",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium
                        )
                        TokenBadge(text = "1 a 6 dp")
                    }
                    Slider(
                        value = liveStroke,
                        onValueChange = { viewModel.setStrokeWidth(it) },
                        valueRange = 1f..6f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("stroke_width_slider")
                    )
                }
            }
        }

        // Corner radius styles catalog
        item {
            Text(
                text = "Estilos de Esquinas Estandarizados",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        items(cornerVariants.size) { index ->
            val variant = cornerVariants[index]
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = variant.title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        TokenBadge(
                            text = variant.dpLabel,
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = variant.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Examples of card and button with this shape
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Styled Card
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    variant.shape
                                )
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Tarjeta ${variant.dpLabel}",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Styled Button
                        Button(
                            onClick = { },
                            shape = variant.shape,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Botón",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }

        // Border stroke variations catalog
        item {
            Text(
                text = "Grosores de Borde y Trazo",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        items(borderVariants.size) { index ->
            val stroke = borderVariants[index]
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 64.dp, height = 48.dp)
                            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                            .border(stroke.thickness.dp, stroke.color, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stroke.thicknessLabel,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stroke.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            TokenBadge(text = stroke.thicknessLabel)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = stroke.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
