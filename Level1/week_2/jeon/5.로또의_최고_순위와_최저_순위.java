import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int winNumCount = 0;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        Arrays.sort(win_nums);
        for (int lotto : lottos) {
            if (lotto == 0) zeroCount++;
            if (Arrays.binarySearch(win_nums, lotto) > -1) winNumCount++;
        }
        
        return new int[]{rank[zeroCount + winNumCount], rank[winNumCount]};
    }
}