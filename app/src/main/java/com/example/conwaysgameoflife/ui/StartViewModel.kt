package com.example.conwaysgameoflife.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StartViewModel : ViewModel() {
    private val _showSheet = MutableStateFlow(false)
    val showSheet: StateFlow<Boolean> = _showSheet
    private val _gridSize = MutableStateFlow(20)
    val gridSize: StateFlow<Int> = _gridSize

    fun onToggleSize(isVisible: Boolean) {
        _showSheet.value = isVisible
    }
    fun onSizeChanged(newSize: Float){
        _gridSize.value = newSize.toInt()
    }

}