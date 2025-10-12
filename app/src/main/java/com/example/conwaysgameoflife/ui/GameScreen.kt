package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.conwaysgameoflife.ui.theme.Pixelify


@Composable
fun GameScreen() {
    val viewModel : LifeViewModel = viewModel()
    val gameState by viewModel.gameState.collectAsState()
    val haptics = LocalHapticFeedback.current

    Column (modifier = Modifier.fillMaxSize()
        .background(Color(0XFFFFFFFF)),
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
                Text(modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp),
                    text ="Conway's Game Of Life",
                    fontFamily = Pixelify,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp,
                )
                Box(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 45.dp, end = 45.dp, top = 15.dp, bottom = 15.dp)
                        .border(1.dp, Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    GameGrid(state.grid,
                        onCellClick = {x, y -> viewModel.onCellClicked(x, y)})
                }
                ControlButtons(
                    onStart = {
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                        viewModel.onStart()
                    },
                    onStop = {
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                        viewModel.onStop()
                    },
                    onRandomize = {
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                        viewModel.onRandomize()
                    },
                    onStep = {
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                        viewModel.onStep()
                    },
                    onReset = {
                        haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                        viewModel.onReset()
                    }
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
    onReset: () -> Unit
) {
    Card (
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Text(modifier = Modifier.align(Alignment.CenterHorizontally)
            .padding(vertical = 10.dp),
            text ="Controls",
            fontFamily = Pixelify,
            color = Color.Black,
            fontSize = 24.sp,
        )
        Row {
            StyledButtons(
                text = "Start",
                onClick = onStart,
                modifier = Modifier.weight(1f)
            )
            StyledButtons(
                text = "Stop",
                onClick = onStop,
                modifier = Modifier.weight(1f)
            )
        }
        Row {
            StyledButtons(
                text = "Randomize",
                onClick = onRandomize,
                modifier = Modifier.weight(1f)
            )
            StyledButtons(
                text = "Step",
                onClick = onStep,
                modifier = Modifier.weight(1f)
            )
            StyledButtons(
                text = "Reset",
                onClick = onReset,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun StyledButtons(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box (
        modifier
            .background(Color.White)
            .border(1.dp, Color.Black)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = Pixelify,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
}
