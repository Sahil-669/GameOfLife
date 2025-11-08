package com.example.conwaysgameoflife.data

import kotlin.random.Random

class Grid (val width: Int, val height: Int) {

    private val grid: Array<BooleanArray> = Array(width) { BooleanArray(height) }

    fun randomize() {
        for ( x in 0 until width ) {
            for (y in 0 until height) {
                grid[x][y] = Random.nextBoolean()
            }
        }
    }

    fun getCell(x: Int, y: Int): Boolean {
        return grid[x][y]
    }

    fun setCell(x: Int, y: Int, state: Boolean) {
        grid[x][y] = state
    }

    fun toggleCell(x: Int, y: Int) {
        grid[x][y] = !grid[x][y]
    }

    fun copy(): Grid {
        val newGrid = Grid(width,height)
        for (x in 0 until width) {
            for (y in 0 until height) {
                newGrid.setCell(x,y, this.getCell(x, y))
            }
        }
        return newGrid
    }

    fun placePattern(pattern: PresetPattern, startX: Int, startY: Int) {
        for (point in pattern.shape) {
            val x = startX + point.first
            val y = startY + point.second
            if (x  in 0 until width && y in 0 until height) {
                setCell(x, y, true)
            }
        }
    }

}



