class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val currentPosition = players.mapIndexed { index, player ->
            player to index
        }.toMap(mutableMapOf())

        callings.forEach {
            val outrunPosition = currentPosition[it]!!
            val outrunned = players[outrunPosition - 1]
            players[outrunPosition - 1] = it
            players[outrunPosition] = outrunned
            currentPosition[outrunned] = outrunPosition
            currentPosition[it] = outrunPosition - 1
        }

        return players
    }
}