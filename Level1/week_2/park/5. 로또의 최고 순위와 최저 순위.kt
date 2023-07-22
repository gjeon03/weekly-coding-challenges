import kotlin.math.min

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var lostNumbers = 0
        var score = 0
        lottos.forEach { value ->
            if (value == 0) {
                lostNumbers++
            } else if (value in win_nums) {
                score++
            }
        }

        // 그냥 맞춘 개수 -> 순위로 맵핑하는게 더 직관적일지도.
        val minScore = min(6 - score + 1, 6)
        return if (lostNumbers == 0) {
            intArrayOf(minScore, minScore)
        } else {
            intArrayOf(maxOf(1, minScore - lostNumbers), minScore)
        }
    }
}