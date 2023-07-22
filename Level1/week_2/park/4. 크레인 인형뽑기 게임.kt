import java.util.Deque
import java.util.LinkedList

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val height = board.size
        val pickedStack = LinkedList<Int>() as Deque<Int>
        var score = 0
        moves.forEach {
            val widthIndex = it - 1
            var heightIndex = 0
            while(heightIndex < height) {
                if(board[heightIndex][widthIndex] != 0) {
                    if(pickedStack.peekLast() == board[heightIndex][widthIndex]) {
                        pickedStack.removeLast()
                        score++
                    } else {
                        pickedStack.addLast(board[heightIndex][widthIndex])
                    }
                    board[heightIndex][widthIndex] = 0
                    break
                }
                heightIndex++
            }
        }

        return score * 2
    }
}