package com.example.conwaysgameoflife.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conwaysgameoflife.data.Grid
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
    private val gridWidth = 15
    private val gridHeight = 30

    init {
        val initialGrid = Grid(gridWidth, gridHeight)
        _gameState.value = GameState.Playing(initialGrid)
    }

    private var gameLoopJob: Job? = null

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
            currentState.grid.randomize()
            _gameState.value = GameState.Playing(currentState.grid)
        }
    }

    fun onStep() {
        val currentState = _gameState.value
        if (currentState is GameState.Playing) {
            val nextGrid = nextGeneration(currentState.grid)
            _gameState.value = GameState.Playing(nextGrid)
        }
    }
}