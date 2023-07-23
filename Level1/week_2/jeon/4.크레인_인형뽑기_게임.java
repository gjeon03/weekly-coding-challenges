import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Integer> basket = new ArrayList<>();
        int count = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    int size = basket.size();
                    if (size > 0 && basket.get(size - 1) == board[i][move - 1]) {
                        basket.remove(size - 1);
                        count += 2;
                    } else {
                        basket.add(board[i][move - 1]);    
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return count;
    }
}


// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public int solution(int[][] board, int[] moves) {
//         List<Integer> basket = new ArrayList<>();
//         int count = 0;

//         for (int move : moves) {
//             for (int i = 0; i < board.length; i++) {
//                 if (board[i][move - 1] != 0) {
//                     basket.add(board[i][move - 1]);
//                     board[i][move - 1] = 0;
//                     break;
//                 }
//             }
//         }

//         for (int i = 1; i < basket.size(); i++) {
//             int toy1 = basket.get(i - 1);
//             int toy2 = basket.get(i);
//             if (toy1 == toy2) {
//                 basket.remove(i - 1);
//                 basket.remove(i - 1);
//                 i = 0;
//                 count += 2;
//             }
//         }

//         return count;
//     }
// }
