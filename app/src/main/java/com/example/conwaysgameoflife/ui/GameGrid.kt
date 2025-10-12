package com.example.conwaysgameoflife.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.conwaysgameoflife.data.Grid

@Composable
fun GameGrid (grid: Grid,
              onCellClick: (x: Int, y: Int) -> Unit,
              showGrid: Boolean
) {
    Column (modifier = Modifier
        .padding(horizontal = 15.dp, vertical = 10.dp)
        .border(width = 1.dp, Color.Black)
    ) {
        repeat(grid.height) { y ->
            Row(modifier = Modifier.fillMaxWidth()) {
              repeat(grid.width) { x ->
                  val isAlive = grid.getCell(x, y)
                  Box(modifier = Modifier
                      .weight(1f)
                      .aspectRatio(1f)
                      .background(if (isAlive) Color(0xFF000000) else Color(0xFFFFFFFF))
                      .then(
                          if (showGrid) {
                              Modifier.border(0.5.dp, Color.LightGray)
                          } else {
                              Modifier
                          }
                      )
                      .clickable { onCellClick(x, y) }
                  )
              }
            }
        }
    }
}