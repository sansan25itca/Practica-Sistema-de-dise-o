package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ui.theme.ThemeMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DesignSystemViewModel : ViewModel() {

    // Global Theme State
    private val _themeMode = MutableStateFlow(ThemeMode.LIGHT)
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
    }

    fun toggleDarkMode(enableDark: Boolean) {
        _themeMode.value = if (enableDark) ThemeMode.DARK else ThemeMode.LIGHT
    }

    // Typography Playground State
    private val _customTypographyText = MutableStateFlow("Sistemas de Diseño en Android")
    val customTypographyText: StateFlow<String> = _customTypographyText.asStateFlow()

    fun updateTypographyText(text: String) {
        _customTypographyText.value = text
    }

    // Shapes & Borders Playground State
    private val _interactiveCornerRadius = MutableStateFlow(12f)
    val interactiveCornerRadius: StateFlow<Float> = _interactiveCornerRadius.asStateFlow()

    private val _interactiveStrokeWidth = MutableStateFlow(2f)
    val interactiveStrokeWidth: StateFlow<Float> = _interactiveStrokeWidth.asStateFlow()

    fun setCornerRadius(radius: Float) {
        _interactiveCornerRadius.value = radius
    }

    fun setStrokeWidth(width: Float) {
        _interactiveStrokeWidth.value = width
    }

    // Spacing Playground State
    private val _interactivePadding = MutableStateFlow(16f)
    val interactivePadding: StateFlow<Float> = _interactivePadding.asStateFlow()

    fun setPadding(padding: Float) {
        _interactivePadding.value = padding
    }

    // Animation Demo State
    private val _isCardExpanded = MutableStateFlow(false)
    val isCardExpanded: StateFlow<Boolean> = _isCardExpanded.asStateFlow()

    fun toggleCardExpansion() {
        _isCardExpanded.value = !_isCardExpanded.value
    }

    private val _colorCycleIndex = MutableStateFlow(0)
    val colorCycleIndex: StateFlow<Int> = _colorCycleIndex.asStateFlow()

    fun cycleAnimationColor() {
        _colorCycleIndex.value = (_colorCycleIndex.value + 1) % 4
    }

    private val _animationBoxScale = MutableStateFlow(1f)
    val animationBoxScale: StateFlow<Float> = _animationBoxScale.asStateFlow()

    fun toggleBoxScale() {
        _animationBoxScale.value = if (_animationBoxScale.value == 1f) 1.25f else 1f
    }

    // Icons Filter State
    private val _iconFilterCategory = MutableStateFlow("Todos")
    val iconFilterCategory: StateFlow<String> = _iconFilterCategory.asStateFlow()

    fun setIconCategory(category: String) {
        _iconFilterCategory.value = category
    }

    private val _iconSearchQuery = MutableStateFlow("")
    val iconSearchQuery: StateFlow<String> = _iconSearchQuery.asStateFlow()

    fun setIconSearchQuery(query: String) {
        _iconSearchQuery.value = query
    }
}
