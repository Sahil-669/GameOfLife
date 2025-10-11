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

}



