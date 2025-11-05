package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conwaysgameoflife.R
import com.example.conwaysgameoflife.ui.theme.Pixelify

@Composable
fun StartScreen() {
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
                onClick = {}
            )
            StyledButtons(
                "How To Play?",
                onClick = {}
            )
            StyledButtons(
                "Grid Size",
                onClick = {}
            )
        }
    }
}