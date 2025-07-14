package leetcode.p2402

import java.util.Comparator
import java.util.PriorityQueue
import kotlin.math.max

class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        var maxEnd = 0
        val meetingQueue = PriorityQueue<IntArray> { a, b ->
            if ((a[1] <= maxEnd && b[1] <= maxEnd) || a[0] == b[0]) a[1] - b[1] else a[0] - b[0]
        }
        val roomQueue = PriorityQueue<IntArray> { a, b ->
            if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0]
        }
        val resultRoomCounts = IntArray(n)

        meetings.forEach { meeting ->
            meetingQueue.add(meeting)
        }

        for (roomNum in 0 until n) {
            roomQueue.add(intArrayOf(0, roomNum))
        }

        while (meetingQueue.isNotEmpty()) {
            val meeting = meetingQueue.poll()
            val room = roomQueue.poll()
            if (room[0] <= meeting[0]) {
                val nextMeeting = if (meetingQueue.isNotEmpty()) meetingQueue.peek() else intArrayOf(0, 0)
                room[0] = max(nextMeeting[0], meeting[1])
            } else {
                room[0] += meeting[1] - meeting[0]
            }
            maxEnd = room[0]
            resultRoomCounts[room[1]]++
            roomQueue.add(room)
        }

        var result = -1;
        var max = 0
        resultRoomCounts.forEachIndexed { i, it ->
            if (it > max) {
                max = it
                result = i
            }
        }

        return result
    }
}

fun main() {
    println(
        Solution().mostBooked(
            4,
            arrayOf(
                intArrayOf(18, 19),
                intArrayOf(3, 12),
                intArrayOf(17, 19),
                intArrayOf(2, 13),
                intArrayOf(7, 10)
            )
        )
    )
    println(
        Solution().mostBooked(
            3,
            arrayOf(
                intArrayOf(1, 20),
                intArrayOf(2, 10),
                intArrayOf(3, 5),
                intArrayOf(4, 9),
                intArrayOf(6, 8)
            )
        )
    )
}