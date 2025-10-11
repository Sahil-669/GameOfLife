package com.example.conwaysgameoflife.domain

import com.example.conwaysgameoflife.data.Grid

fun nextGeneration(grid: Grid): Grid {
    val newGrid = Grid(grid.width, grid.height)

    for (x in 0 until grid.width) {
        for (y in 0 until grid.height) {
            val neighbors = countNeighbors(grid,x,y)
            val isAlive = grid.getCell(x,y)
            val nextState = when{
                isAlive && neighbors in 2..3 -> true
                !isAlive && neighbors == 3 -> true
                else -> false
            }
            newGrid.setCell(x,y,nextState)
        }
    }
    return newGrid
}

fun countNeighbors(grid: Grid, x: Int, y: Int): Int {
    var count = 0;
    for (dx in -1..1) {
        for (dy in -1..1) {
            if (dx == 0 && dy == 0) {
                continue
            }

            val neighborX = x + dx
            val neighborY = y + dy

            if (neighborX in 0 until grid.width && neighborY in 0 until grid.height) {
                if (grid.getCell(neighborX, neighborY)) {
                    count++
                }
            }
        }
    }
    return count
}
