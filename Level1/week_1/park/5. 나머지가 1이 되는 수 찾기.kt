class Solution {
    public int solution(int n) {
        for(var i=1;i<n;i++) {
            if(n % i == 1) return i;
        }
        
        return -1;
    }
}
