package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun GameScreen() {
    val viewModel : LifeViewModel = viewModel()
    val gameState by viewModel.gameState.collectAsState()

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val state = gameState) {
            is GameState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is GameState.Playing -> {
                GameGrid(state.grid)
                Spacer(modifier = Modifier.weight(1f))
                ControlButtons(
                        onStart = { viewModel.onStart() },
                        onStop = { viewModel.onStop() },
                        onRandomize = { viewModel.onRandomize() },
                        onStep = { viewModel.onStep() }
                )
            }
        }
    }
}

@Composable
fun ControlButtons(
    onStart: () -> Unit,
    onStop: () -> Unit,
    onRandomize: () -> Unit,
    onStep: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row ( modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = onStart) {
            Text("Start")
        }
        Button(onClick = onStop) {
            Text("Stop")
        }
        Button(onClick = onRandomize) {
            Text("Random")
        }
        Button(onClick = onStep) {
            Text("Step")
        }
    }
}


@Composable
fun PreviewG() {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 50.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(1f).fillMaxWidth()) {
            repeat(25) { y ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    repeat(14) { x ->
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .background(Color(0xFF000000))
                                .border(0.5.dp, Color.LightGray)
                        )
                    }
                }
            }
        }
        Row ( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {}) {
                Text("Start")
            }
            Button(onClick = {  }) {
                Text("Stop")
            }
            Button(onClick = {  }) {
                Text("Random")
            }
            Button(onClick = {}) {
                Text("Step")
            }
        }
    }
}
