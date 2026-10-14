package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.EducationalBanner
import com.example.ui.components.TokenBadge
import com.example.viewmodel.DesignSystemViewModel

data class TypographyStyleItem(
    val category: String,
    val name: String,
    val style: TextStyle,
    val sizeSp: String,
    val description: String
)

@Composable
fun TypographyScreen(
    viewModel: DesignSystemViewModel,
    modifier: Modifier = Modifier
) {
    val customText by viewModel.customTypographyText.collectAsState()

    val typographyStyles = listOf(
        TypographyStyleItem(
            category = "Display",
            name = "Display Large",
            style = MaterialTheme.typography.displayLarge,
            sizeSp = "57 sp",
            description = "Texto de máximo impacto visual para portadas o números destacados."
        ),
        TypographyStyleItem(
            category = "Display",
            name = "Display Medium",
            style = MaterialTheme.typography.displayMedium,
            sizeSp = "45 sp",
            description = "Destacados principales en pantallas de bienvenida y paneles."
        ),
        TypographyStyleItem(
            category = "Display",
            name = "Display Small",
            style = MaterialTheme.typography.displaySmall,
            sizeSp = "36 sp",
            description = "Titulares de gran tamaño para destacar contenido breve."
        ),
        TypographyStyleItem(
            category = "Headline",
            name = "Headline Large",
            style = MaterialTheme.typography.headlineLarge,
            sizeSp = "32 sp",
            description = "Encabezados principales de pantalla."
        ),
        TypographyStyleItem(
            category = "Headline",
            name = "Headline Medium",
            style = MaterialTheme.typography.headlineMedium,
            sizeSp = "28 sp",
            description = "Encabezados secundarios y subtítulos mayores."
        ),
        TypographyStyleItem(
            category = "Headline",
            name = "Headline Small",
            style = MaterialTheme.typography.headlineSmall,
            sizeSp = "24 sp",
            description = "Encabezados de subsecciones importantes."
        ),
        TypographyStyleItem(
            category = "Title",
            name = "Title Large",
            style = MaterialTheme.typography.titleLarge,
            sizeSp = "22 sp",
            description = "Títulos de tarjetas principales, diálogos y barras de navegación."
        ),
        TypographyStyleItem(
            category = "Title",
            name = "Title Medium",
            style = MaterialTheme.typography.titleMedium,
            sizeSp = "16 sp",
            description = "Títulos de elementos en listas y grupos de contenido."
        ),
        TypographyStyleItem(
            category = "Title",
            name = "Title Small",
            style = MaterialTheme.typography.titleSmall,
            sizeSp = "14 sp",
            description = "Títulos compactos para widgets y tarjetas densas."
        ),
        TypographyStyleItem(
            category = "Body",
            name = "Body Large",
            style = MaterialTheme.typography.bodyLarge,
            sizeSp = "16 sp",
            description = "Texto estándar de lectura para párrafos largos."
        ),
        TypographyStyleItem(
            category = "Body",
            name = "Body Medium",
            style = MaterialTheme.typography.bodyMedium,
            sizeSp = "14 sp",
            description = "Texto secundario de lectura en tarjetas y descripciones breves."
        ),
        TypographyStyleItem(
            category = "Body",
            name = "Body Small",
            style = MaterialTheme.typography.bodySmall,
            sizeSp = "12 sp",
            description = "Párrafos compactos, notas al pie y anotaciones legales."
        ),
        TypographyStyleItem(
            category = "Label",
            name = "Label Large",
            style = MaterialTheme.typography.labelLarge,
            sizeSp = "14 sp",
            description = "Etiquetas de botones principales y pestañas interactivas."
        ),
        TypographyStyleItem(
            category = "Label",
            name = "Label Medium",
            style = MaterialTheme.typography.labelMedium,
            sizeSp = "12 sp",
            description = "Insignias (badges), filtros y chips secundarios."
        ),
        TypographyStyleItem(
            category = "Label",
            name = "Label Small",
            style = MaterialTheme.typography.labelSmall,
            sizeSp = "11 sp",
            description = "Metadatos mínimos, timestamps y leyendas técnicas."
        )
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("typography_screen")
    ) {
        // Educational Banner
        item {
            EducationalBanner(
                title = "Fundamento: Escala Tipográfica M3",
                description = "La tipografía define la jerarquía visual de la interfaz. En Android, las fuentes se miden en sp (Scale-independent Pixels) para respetar el tamaño de fuente elegido por el usuario en Ajustes de accesibilidad."
            )
        }

        // Interactive Playground Input
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Banco de Pruebas Tipográfico",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Escribe una frase para ver cómo se adapta en tiempo real a cada nivel de la escala:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = customText,
                        onValueChange = { viewModel.updateTypographyText(it) },
                        label = { Text("Texto de muestra") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("typography_input_field"),
                        singleLine = true
                    )
                }
            }
        }

        // Font Weights Section
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Grosores de Fuente (Font Weights)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    val weights = listOf(
                        "Light (300)" to FontWeight.Light,
                        "Normal / Regular (400)" to FontWeight.Normal,
                        "Medium (500)" to FontWeight.Medium,
                        "SemiBold (600)" to FontWeight.SemiBold,
                        "Bold (700)" to FontWeight.Bold
                    )
                    weights.forEach { (label, weight) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = customText,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = weight),
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            TokenBadge(text = label)
                        }
                    }
                }
            }
        }

        // Typography Styles list
        item {
            Text(
                text = "Catálogo de Estilos de Texto",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        items(typographyStyles.size) { index ->
            val item = typographyStyles[index]
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
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
                            text = item.name,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            TokenBadge(text = item.category)
                            TokenBadge(
                                text = item.sizeSp,
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Real visual sample
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    ) {
                        Text(
                            text = customText,
                            style = item.style,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
