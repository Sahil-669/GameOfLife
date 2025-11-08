package com.example.conwaysgameoflife.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StartViewModel : ViewModel() {
    private val _showSheet = MutableStateFlow(false)
    val showSheet: StateFlow<Boolean> = _showSheet
    private val _gridWidth = MutableStateFlow(20)
    val gridWidth: StateFlow<Int> = _gridWidth
    private val _gridHeight = MutableStateFlow(20)
    val gridHeight: StateFlow<Int> = _gridHeight

    fun onToggleSize(isVisible: Boolean) {
        _showSheet.value = isVisible
    }

    fun onWidthChanged(width : Float) {
        _gridWidth.value = width.toInt()
    }
    fun onHeightChanged(height : Float) {
        _gridHeight.value = height.toInt()
    }
}