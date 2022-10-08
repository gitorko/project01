package com.demo.leetcode.medium._06_wallgate_286

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class WallGateKt {

    @Test
    fun test() {
        val rooms = arrayOf(intArrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE), intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1), intArrayOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1), intArrayOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE))
        val expected = arrayOf(intArrayOf(3, -1, 0, 1), intArrayOf(2, 2, 1, -1), intArrayOf(1, -1, 2, -1), intArrayOf(0, -1, 3, 4))
        wallsAndGates(rooms)
        Assertions.assertArrayEquals(expected, rooms)
    }

    /**
     * Time: O(mn)
     * Space: O(mn)
     *
     * 0 is gate
     * -1 is wall
     * inf is room
     */
    var rowLen = 0
    var colLen = 0
    var visited: Array<BooleanArray> = arrayOf()
    var queue: LinkedList<IntArray> = LinkedList()
    var rooms: Array<IntArray> = arrayOf();

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        this.rooms = rooms
        rowLen = rooms.size
        colLen = rooms[0].size
        queue = LinkedList()
        visited = Array(rowLen) { BooleanArray(colLen) }
        for (i in 0 until rowLen) {
            for (j in 0 until colLen) {
                if (rooms[i][j] == 0) {
                    //add all gates
                    queue.offer(intArrayOf(i, j))
                    visited[i][j] = true
                }
            }
        }
        var distance = 0
        while (!queue.isEmpty()) {
            var level = queue.size
            while (level > 0) {
                val p = queue.poll()
                val i = p[0]
                val j = p[1]
                rooms[i][j] = distance
                addRoom(i + 1, j)
                addRoom(i - 1, j)
                addRoom(i, j + 1)
                addRoom(i, j - 1)
                level--
            }
            distance++
        }
    }

    private fun addRoom(i: Int, j: Int) {
        if (i < 0 || j < 0 || i == rowLen || j == colLen || visited[i][j] || rooms[i][j] == -1) {
            return
        }
        visited[i][j] = true
        queue.offer(intArrayOf(i, j))
    }
}
