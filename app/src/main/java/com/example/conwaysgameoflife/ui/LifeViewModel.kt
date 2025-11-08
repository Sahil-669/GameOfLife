package com.example.conwaysgameoflife.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conwaysgameoflife.data.Grid
import com.example.conwaysgameoflife.data.PresetPattern
import com.example.conwaysgameoflife.domain.nextGeneration
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class GameState {
    object Loading : GameState()
    data class Playing(val grid: Grid) : GameState()
}

class LifeViewModel : ViewModel() {
    private val _gameState: MutableStateFlow<GameState> = MutableStateFlow(GameState.Loading)
    val gameState: StateFlow<GameState> = _gameState
    private val _showGrid = MutableStateFlow(true)
    val showGrid: StateFlow<Boolean> = _showGrid
    private var gameLoopJob: Job? = null

    fun initGame(width: Int, height: Int) {
        val initialGrid = Grid(width, height)
        _gameState.value = GameState.Playing(initialGrid)
    }
    fun onStart() {
        if (gameLoopJob?.isActive == true) return

        gameLoopJob = viewModelScope.launch {
            while (true) {
                val currentState = _gameState.value
                if (currentState is GameState.Playing) {
                    val nextGrid = nextGeneration(currentState.grid)
                    _gameState.value = GameState.Playing(nextGrid)
                }
                delay(100L)
            }
        }
    }

    fun onStop() {
        gameLoopJob?.cancel()
    }

    fun onRandomize() {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            onStop()
            val newGrid = Grid(currentState.grid.width, currentState.grid.height)
            newGrid.randomize()
            _gameState.value = GameState.Playing(newGrid)
        }
    }

    fun onStep() {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            val nextGrid = nextGeneration(currentState.grid)
            _gameState.value = GameState.Playing(nextGrid)
        }
    }

    fun onReset() {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            val newGrid = Grid(currentState.grid.width, currentState.grid.height)
            _gameState.value = GameState.Playing(newGrid)
        }
    }

    fun onCellClicked(x: Int, y: Int) {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            onStop()
            val newGrid = currentState.grid.copy().apply {
                toggleCell(x, y)
            }
            _gameState.value = GameState.Playing(newGrid)
        }
    }

    fun onToggleGrid() {
        _showGrid.value = !_showGrid.value
    }

    fun onPresetSelected(pattern : PresetPattern) {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            onStop()
            val currentWidth = currentState.grid.width
            val currentHeight = currentState.grid.height
            val newGrid = Grid(currentWidth, currentHeight)
            val startX = (currentWidth/2) - 5
            val startY = (currentHeight/2) - 5
            newGrid.placePattern(pattern, startX, startY)
            _gameState.value = GameState.Playing(newGrid)
        }

    }
}