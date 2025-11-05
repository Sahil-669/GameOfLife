package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conwaysgameoflife.ui.theme.Pixelify

@Composable
fun HelpScreen() {
    val scrollState1 = rememberScrollState()
    val scrollState2 = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "How To Play?",
            fontFamily = Pixelify,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .size(190.dp)
                .border(1.dp, Color.Black)
                .padding(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "1. TAP TO TOGGLE",
                    fontFamily = Pixelify,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Create your own pattern or let the app decide.\nTouch a cell to make it Alive or Dead.",
                    fontFamily = Pixelify
                )
            }
        }

        Box(
            modifier = Modifier
                .size(190.dp)
                .border(1.dp, Color.Black)
                .padding(12.dp)
                .verticalScroll(scrollState1)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "2. THE RULES",
                    fontFamily = Pixelify,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "A live cell survives if it has 2 or 3 live neighbors, but dies from isolation (fewer than 2 neighbors) or overcrowding (more than 3 neighbors)." +
                            "\nA dead cell becomes a live cell (reproduces) if it has exactly 3 live neighbors",
                    fontFamily = Pixelify
                )
            }
        }

        Box(
            modifier = Modifier
                .size(190.dp)
                .border(1.dp, Color.Black)
                .padding(12.dp)
                .verticalScroll(scrollState2)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "3. THE BUTTONS",
                    fontFamily = Pixelify,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Press START to start the simulation and STOP to stop it."+
                            "\nPress RANDOMIZE to randomly create patterns."+
                            "\nPress RESET to clear the grid."+
                            "\nPress STEP to advance the grid to the next generation.",
                    fontFamily = Pixelify
                )
            }
        }
        StyledButtons(
            "GOT IT! LET'S PLAY!",
            {}
        )
    }
}
