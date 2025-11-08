package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conwaysgameoflife.R
import com.example.conwaysgameoflife.ui.theme.Pixelify
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    viewModel: StartViewModel,
    onNavigateToGame: () -> Unit,
    onNavigateToHelp: () -> Unit
) {
    val showSheet by viewModel.showSheet.collectAsState()
    val gridWidth by viewModel.gridWidth.collectAsState()
    val gridHeight by viewModel.gridHeight.collectAsState()
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                Modifier.size(55.dp)
            )
            Text(
                "Conway's Game Of Life",
                fontFamily = Pixelify,
                fontSize = 35.sp,
                textAlign = TextAlign.Center
            )
            StyledButtons(
                text = "New Game",
                onClick = onNavigateToGame
            )
            StyledButtons(
                "How To Play?",
                onClick = onNavigateToHelp
            )
            StyledButtons(
                "Grid Size",
                onClick = {viewModel.onToggleSize(true)}
            )
        }
    }
    if (showSheet) {
        ModalBottomSheet (
            sheetState = sheetState,
            onDismissRequest = {
                viewModel.onToggleSize(false)
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Set Grid Size",
                    fontFamily = Pixelify,
                    fontSize = 20.sp
                )
                Text(
                    "Width: $gridWidth"
                )
                Slider(
                    value = gridWidth.toFloat(),
                    onValueChange = {viewModel.onWidthChanged(it)},
                    valueRange = 10f..50f,
                    steps = 39
                )
                Text(
                    "Height: $gridHeight"
                )
                Slider(
                    value = gridHeight.toFloat(),
                    onValueChange = {viewModel.onHeightChanged(it)},
                    valueRange = 10f..50f,
                    steps = 39
                )
            }
        }
    }
    LaunchedEffect(showSheet) {
        scope.launch {
            if (showSheet) {
                sheetState.show()
            } else {
                sheetState.hide()
            }
        }
    }
}