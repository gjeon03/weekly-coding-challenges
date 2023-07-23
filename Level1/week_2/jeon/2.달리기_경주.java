import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int targetIndex = playerMap.get(calling);
            if (targetIndex > 0) {
                String tempValue = players[targetIndex - 1];
                players[targetIndex - 1] = players[targetIndex];
                players[targetIndex] = tempValue;
                playerMap.put(players[targetIndex - 1], targetIndex - 1);
                playerMap.put(players[targetIndex], targetIndex);
            }
        }

        return players;
    }
}


// import java.util.Arrays;
// import java.util.List;
// import java.util.ArrayList;

// class Solution {
//     public String[] solution(String[] players, String[] callings) {
//         List<String> playerList = new ArrayList<>(Arrays.asList(players));
        
//         Arrays.stream(callings).forEach((v) -> {
//             int targetIndex = playerList.indexOf(v);
//             int prev = targetIndex - 1;
//             String tempValue = playerList.get(prev);
            
//             playerList.set(prev,playerList.get(targetIndex));
//             playerList.set(targetIndex, tempValue);
//         });
        
//         return playerList.toArray(new String[0]);
//     }
// }