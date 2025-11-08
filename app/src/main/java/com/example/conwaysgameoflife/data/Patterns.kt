package com.example.conwaysgameoflife.data

typealias PatternShape = List<Pair<Int, Int>>

sealed class PresetPattern(val shape: PatternShape) {
    object Glider : PresetPattern (
        listOf(
            Pair(1,0),
            Pair(2,1),
            Pair(0,2),
            Pair(1,2),
            Pair(2,2)
        )
    )
    object Pulsar : PresetPattern(
        listOf(
            Pair(2, 0), Pair(3, 0), Pair(4, 0),
            Pair(8, 0), Pair(9, 0), Pair(10, 0),
            Pair(0, 2), Pair(5, 2), Pair(7, 2), Pair(12, 2),
            Pair(0, 3), Pair(5, 3), Pair(7, 3), Pair(12, 3),
            Pair(0, 4), Pair(5, 4), Pair(7, 4), Pair(12, 4),
            Pair(2, 5), Pair(3, 5), Pair(4, 5),
            Pair(8, 5), Pair(9, 5), Pair(10, 5),
            Pair(2, 7), Pair(3, 7), Pair(4, 7),
            Pair(8, 7), Pair(9, 7), Pair(10, 7),
            Pair(0, 8), Pair(5, 8), Pair(7, 8), Pair(12, 8),
            Pair(0, 9), Pair(5, 9), Pair(7, 9), Pair(12, 9),
            Pair(0, 10), Pair(5, 10), Pair(7, 10), Pair(12, 10),
            Pair(2, 12), Pair(3, 12), Pair(4, 12),
            Pair(8, 12), Pair(9, 12), Pair(10, 12)
        )
    )
    object GliderGun : PresetPattern(
        listOf(
            Pair(0, 4), Pair(0, 5), Pair(1, 4), Pair(1, 5),
            Pair(10, 4), Pair(10, 5), Pair(10, 6),
            Pair(11, 3), Pair(11, 7),
            Pair(12, 2), Pair(12, 8),
            Pair(13, 2), Pair(13, 8),
            Pair(14, 5),
            Pair(15, 3), Pair(15, 7),
            Pair(16, 4), Pair(16, 5), Pair(16, 6),
            Pair(17, 5),
            Pair(20, 2), Pair(20, 3), Pair(20, 4),
            Pair(21, 2), Pair(21, 3), Pair(21, 4),
            Pair(22, 1), Pair(22, 5),
            Pair(24, 0), Pair(24, 1), Pair(24, 5), Pair(24, 6),
            Pair(34, 2), Pair(34, 3),
            Pair(35, 2), Pair(35, 3)
        )
    )
    object RPentomino : PresetPattern(
        listOf(
            Pair(1, 0), Pair(2, 0),
            Pair(0, 1), Pair(1, 1),
            Pair(1, 2)
        )
    )
}