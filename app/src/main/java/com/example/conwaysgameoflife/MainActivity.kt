package com.example.conwaysgameoflife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.conwaysgameoflife.ui.GameScreen
import com.example.conwaysgameoflife.ui.theme.ConwaysGameOfLifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConwaysGameOfLifeTheme {
                GameScreen()
            }
        }
    }
}
