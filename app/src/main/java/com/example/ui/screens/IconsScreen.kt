package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.components.EducationalBanner
import com.example.ui.components.TokenBadge
import com.example.viewmodel.DesignSystemViewModel

data class IconEntry(
    val name: String,
    val composeName: String,
    val category: String,
    val icon: ImageVector,
    val useCase: String
)

@Composable
fun IconsScreen(
    viewModel: DesignSystemViewModel,
    modifier: Modifier = Modifier
) {
    val selectedCategory by viewModel.iconFilterCategory.collectAsState()
    val searchQuery by viewModel.iconSearchQuery.collectAsState()
    var selectedIconEntry by remember {
        mutableStateOf(
            IconEntry("Inicio", "Icons.Default.Home", "Navegación", Icons.Default.Home, "Pantalla principal o retorno al punto de inicio.")
        )
    }

    val iconList = listOf(
        IconEntry("Inicio", "Icons.Default.Home", "Navegación", Icons.Default.Home, "Pantalla principal o retorno al punto de inicio."),
        IconEntry("Configuración", "Icons.Default.Settings", "Sistema", Icons.Default.Settings, "Preferencias generales, ajustes y opciones."),
        IconEntry("Buscar", "Icons.Default.Search", "Navegación", Icons.Default.Search, "Búsqueda y filtrado de contenido."),
        IconEntry("Favoritos", "Icons.Default.Favorite", "Acciones", Icons.Default.Favorite, "Guardar en favoritos o dar me gusta."),
        IconEntry("Perfil", "Icons.Default.Person", "Sistema", Icons.Default.Person, "Información de cuenta y usuario."),
        IconEntry("Notificaciones", "Icons.Default.Notifications", "Comunicación", Icons.Default.Notifications, "Alertas, recordatorios y avisos del sistema."),
        IconEntry("Editar", "Icons.Default.Edit", "Acciones", Icons.Default.Edit, "Modificar campos, notas o registros existentes."),
        IconEntry("Eliminar", "Icons.Default.Delete", "Acciones", Icons.Default.Delete, "Acción destructiva de borrado o descarte."),
        IconEntry("Compartir", "Icons.Default.Share", "Acciones", Icons.Default.Share, "Enviar contenido mediante el selector nativo."),
        IconEntry("Información", "Icons.Default.Info", "Sistema", Icons.Default.Info, "Detalles explicativos y metadatos de ayuda."),
        IconEntry("Confirmar", "Icons.Default.Check", "Acciones", Icons.Default.Check, "Aprobación de tarea completada."),
        IconEntry("Volver", "Icons.AutoMirrored.Filled.ArrowBack", "Navegación", Icons.AutoMirrored.Filled.ArrowBack, "Retorno jerárquico a la vista anterior."),
        IconEntry("Guardar", "Icons.Default.Bookmark", "Acciones", Icons.Default.Bookmark, "Marcador de lectura o guardado."),
        IconEntry("Descargar", "Icons.Default.Download", "Acciones", Icons.Default.Download, "Descarga de archivos o recursos."),
        IconEntry("Mensaje", "Icons.Default.Mail", "Comunicación", Icons.Default.Mail, "Bandeja de entrada o envío de correos."),
        IconEntry("Teléfono", "Icons.Default.Phone", "Comunicación", Icons.Default.Phone, "Llamadas de soporte o contacto directo.")
    )

    val categories = listOf("Todos", "Navegación", "Acciones", "Sistema", "Comunicación")

    val filteredIcons = iconList.filter { item ->
        val matchesCategory = selectedCategory == "Todos" || item.category == selectedCategory
        val matchesSearch = item.name.contains(searchQuery, ignoreCase = true) ||
                item.category.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
            .testTag("icons_screen")
    ) {
        item {
            EducationalBanner(
                title = "Fundamento: Iconografía Vectorial",
                description = "Los iconos son un lenguaje universal que acelera la comprensión visual y optimiza el espacio de pantalla. En Compose se usan ImageVectors nativos, escalables sin pérdida de nitidez y accesibles mediante 'contentDescription'."
            )
        }

        // Search & Filter
        item {
            Column {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.setIconSearchQuery(it) },
                    placeholder = { Text("Buscar icono por nombre o categoría...") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("icon_search_input"),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { cat ->
                        FilterChip(
                            selected = selectedCategory == cat,
                            onClick = { viewModel.setIconCategory(cat) },
                            label = { Text(cat) }
                        )
                    }
                }
            }
        }

        // Inspector Card for Selected Icon
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = selectedIconEntry.icon,
                            contentDescription = selectedIconEntry.name,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = selectedIconEntry.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            TokenBadge(
                                text = selectedIconEntry.category,
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = selectedIconEntry.useCase,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = selectedIconEntry.composeName,
                            style = MaterialTheme.typography.labelSmall.copy(fontFamily = FontFamily.Monospace),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        // Size Scale Demo
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
                        text = "Escala de Tamaños Estandarizados (dp)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    val sizes = listOf(
                        "16 dp (Mínimo)" to 16.dp,
                        "24 dp (Estándar)" to 24.dp,
                        "32 dp (Énfasis)" to 32.dp,
                        "48 dp (Touch/Hero)" to 48.dp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        sizes.forEach { (label, sizeDp) ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(sizeDp)
                                        .background(MaterialTheme.colorScheme.surface, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = selectedIconEntry.icon,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(sizeDp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = label,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }

        // Catalog of Icons
        item {
            Text(
                text = "Catálogo de Iconos Disponibles (${filteredIcons.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        items(filteredIcons) { item ->
            val isSelected = selectedIconEntry.name == item.name
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    else MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedIconEntry = item }
                    .testTag("icon_item_${item.name.lowercase()}")
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            TokenBadge(text = item.category)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = item.useCase,
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
