# Design System Explorer 📱🎨

**Design System Explorer** es una aplicación móvil nativa para Android desarrollada con **Kotlin** y **Jetpack Compose**, basada en las directrices de **Material Design 3 (M3)**. 

La aplicación fue concebida como un proyecto académico interactivo y educativo cuyo propósito es demostrar, de forma práctica y visual, los conceptos fundamentales que componen un **Sistema de Diseño (Design System)** en el desarrollo de software móvil moderno.

---

## 🚀 Propósito del Proyecto

Un sistema de diseño es el conjunto de estándares, tokens y componentes reutilizables que permiten a los equipos de ingeniería y diseño crear productos consistentes, accesibles y escalables. 

Esta aplicación permite a estudiantes y desarrolladores explorar interactivamente los principios de diseño de interfaces, observar cómo reaccionan los componentes ante cambios de estado y comprender el valor de los tokens de diseño frente al uso de valores fijos o codificados manualmente.

---

## 🌟 Características y Secciones Principales

La aplicación se estructura en una navegación fluida con barra inferior de tres destinos (**Inicio**, **Componentes** y **Ajustes**), integrando siete secciones especializadas:

### 1. 🔤 Tipografía (Typography)
- **Escala completa de Material Design 3:** Muestra de los 15 estilos tipográficos oficiales agrupados en *Display*, *Headline*, *Title*, *Body* y *Label*.
- **Dimensiones en `sp`:** Demostración de tamaños y alturas de línea (line-height) independientes de la densidad para garantizar accesibilidad.
- **Grosores de fuente:** Comparativa visual entre *Light*, *Regular/Normal*, *Medium*, *SemiBold* y *Bold*.
- **Banco de pruebas en vivo:** Campo de texto interactivo para probar cualquier palabra o frase en toda la escala tipográfica al instante.

### 2. 🎨 Colores (Colors & Tokens)
- **Paleta semántica M3:** Muestras de color organizadas por roles funcionales: *Primary*, *Secondary*, *Tertiary*, *Background*, *Surface*, *Error* y *Success*.
- **Pares de contraste accesible:** Representación de colores base y sus correspondientes pares "On-Color" (ej. `Primary` vs `OnPrimary`) para asegurar legibilidad conforme a las pautas WCAG (contraste mínimo 4.5:1).
- **Inspección técnica:** Código hexadecimal de cada muestra (#RRGGBB) y explicación de su caso de uso en la interfaz.

### 3. 🌓 Temas (Themes: Claro y Oscuro)
- **Conmutación en tiempo real:** Interruptor funcional para alternar entre el **Modo Claro**, **Modo Oscuro** y adaptación automática al sistema.
- **Propagación reactiva:** El cambio actualiza de forma inmediata e integral toda la aplicación (fondo, tarjetas, textos, botones, diálogos y barras de navegación) mediante `MaterialTheme.colorScheme`.

### 4. 🔣 Iconos Vectoriales (Icons)
- **Catálogo móvil estándar:** Iconografía esencial que incluye *Inicio*, *Configuración*, *Buscar*, *Favoritos*, *Perfil*, *Notificaciones*, *Editar*, *Eliminar*, *Compartir*, *Información*, *Descargar*, entre otros.
- **Vectores nativos:** Uso exclusivo de `ImageVector` de Jetpack Compose (sin emojis sustitutivos).
- **Escala de tamaños estandarizados:** Comparación de dimensiones en `16 dp`, `24 dp`, `32 dp` y `48 dp`.
- **Buscador y filtros:** Filtrado dinámico por categorías (*Navegación*, *Acciones*, *Sistema*, *Comunicación*) e inspector de código Compose.

### 5. ✨ Animaciones (Motion & Micro-interactions)
- **Escala táctil con resorte:** Tarjeta que aumenta suavemente su tamaño al hacer clic (`animateFloatAsState` con `spring`).
- **Retroalimentación de botón:** Animación elástica de compresión física al mantener pulsado (`collectIsPressedAsState`).
- **Transición fluida de visibilidad:** Mostrar y ocultar contenido con desvanecimiento (`fadeIn`/`fadeOut`) y expansión vertical coordinada (`AnimatedVisibility` + `animateContentSize`).
- **Interpolación cromática:** Cambio gradual y suave entre colores del sistema (`animateColorAsState`).
- **Expansión y contracción dimensional:** Control dinámico de proporciones (`animateDpAsState`).

### 6. 📐 Bordes y Esquinas (Shapes & Borders)
- **4 Estilos geométricos estándar:**
  - *Sin redondeo (Sharp):* 0 dp (RectangleShape).
  - *Ligeramente redondeadas (Small):* 8 dp.
  - *Muy redondeadas (Large):* 24 dp.
  - *Forma circular / Píldora (Full):* CircleShape (50%).
- **Variaciones de contorno:** Ejemplos con grosores de 1 dp, 2 dp y 4 dp en diferentes colores de la paleta.
- **Laboratorio interactivo:** Controles deslizantes (Sliders) para modificar el radio de esquina (0 a 36 dp) y el grosor del borde (1 a 6 dp) en tiempo real.

### 7. 📏 Espaciado (Spacing & 8dp Grid)
- **Sistema modular de 8 dp:** Justificación matemática y de escalabilidad de densidades (mdpi, hdpi, xhdpi, xxhdpi).
- **Escala visual estandarizada:** Muestras comparativas de `4 dp`, `8 dp`, `12 dp`, `16 dp`, `24 dp` y `32 dp`.
- **Demostración de los 3 conceptos fundamentales:**
  1. *Padding interno:* Espacio protector dentro del contenedor.
  2. *Separación entre componentes (Gap):* Distribución armónica entre elementos adyacentes.
  3. *Márgenes exteriores:* Márgenes laterales seguros respecto a la pantalla del dispositivo.
- **Simulador dinámico:** Control deslizante para experimentar con diferentes valores de padding sobre componentes reales.

### 8. 🧩 Galería de Componentes (Components Playground)
- Explorador interactivo con botones de distintos niveles de énfasis (*Filled*, *Tonal*, *Outlined*, *Elevated*, *Text*, *FAB*).
- Controles de selección activos (*Switch*, *Checkbox*, *Radio Buttons*, *Slider*).
- *Chips* interactivos (*Filter*, *Assist*, *Suggestion*), insignias con contador (*BadgedBox*) y barras de progreso lineales y circulares.

---

## 🛠️ Tecnologías y Arquitectura

- **Lenguaje:** [Kotlin](https://kotlinlang.org/) 2.2.
- **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (paradigma declarativo moderno).
- **Sistema de Diseño Base:** Material Design 3 (M3).
- **Arquitectura:** **MVVM (Model - View - ViewModel)** con arquitectura limpia unidireccional (UDF):
  - `MainActivity.kt`: Punto de entrada con `enableEdgeToEdge()` y vinculación del tema.
  - `ui/theme/`: Definición centralizada de `Color.kt`, `Type.kt`, `Shape.kt` y `Theme.kt`.
  - `ui/navigation/`: Control de rutas con `Navigation Compose` (`AppNavigation.kt` y `Screen.kt`).
  - `ui/screens/`: Pantallas independientes, modulares y de responsabilidad única.
  - `ui/components/`: Componentes reutilizables (`AppTopBar`, `BottomNavBar`, `SectionCard`, `EducationalBanner`, `TokenBadge`).
  - `viewmodel/`: `DesignSystemViewModel.kt` para gestión reactiva del estado mediante `StateFlow`.
- **Concurrencia:** Kotlin Coroutines y StateFlow.
- **Persistencia:** Estado reactivo en memoria local (sin dependencias externas ni backend).

---

## 📋 Requisitos para Ejecutar el Proyecto

- **Android Studio:** Ladybug (2024.2+) o superior recomendado.
- **JDK:** Java Development Kit versión 17 o 21.
- **SDK de Android:** 
  - `minSdk`: 24 (Android 7.0 Nougat o superior).
  - `targetSdk`: 36 / Android 15+.
- **Dispositivo o Emulador:** Teléfono o tablet Android con procesador x86_64 o ARM64.

---

## 💻 Instrucciones Paso a Paso para Compilar y Ejecutar

1. **Abrir el proyecto en Android Studio:**
   - Inicia Android Studio.
   - Selecciona **File > Open...** (o *Open* desde la pantalla de bienvenida).
   - Navega hasta el directorio raíz del proyecto y haz clic en **OK**.

2. **Sincronizar Gradle:**
   - Android Studio detectará automáticamente la configuración de Gradle.
   - Si no se inicia automáticamente, haz clic en el icono del elefante en la barra superior: **Sync Project with Gradle Files**.
   - Espera a que finalice la descarga de dependencias y la indexación del proyecto.

3. **Configurar el Emulador o Dispositivo:**
   - Abre el **Device Manager** en Android Studio.
   - Crea o inicia un Dispositivo Virtual Android (AVD) (por ejemplo, Pixel 8 con API 34 o 35).
   - Alternativamente, conecta un dispositivo físico Android con la **Depuración USB** habilitada.

4. **Compilar y Ejecutar:**
   - En la barra de herramientas superior, asegúrate de que el módulo seleccionado sea `app`.
   - Haz clic en el botón verde de reproducir (**Run 'app'**) o presiona `Shift + F10` (`Control + R` en macOS).
   - La aplicación se compilará e instalará automáticamente en el emulador.

---

## 🔧 Solución de Problemas Comunes

- **Error de versión de Java / JDK:**
  - Asegúrate de que Android Studio esté configurado para usar JDK 17 o 21 en:
    `Settings (Preferences) > Build, Execution, Deployment > Build Tools > Gradle > Gradle JDK`.
- **Caché desactualizada de Gradle:**
  - Selecciona en el menú: `File > Invalidate Caches... > Invalidate and Restart`.
- **Recursos duplicados o de compilación previa:**
  - Ejecuta desde la terminal de Android Studio: `gradle clean assembleDebug`.

---

## 📄 Licencia y Uso Académico

Este proyecto se distribuye como material académico y formativo independiente para el estudio y práctica de sistemas de diseño en el desarrollo de software móvil para la plataforma Android.
