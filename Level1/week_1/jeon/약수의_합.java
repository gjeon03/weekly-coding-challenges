class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int temp = n / i;
                
                answer += i + (temp != i ? (n / i) : 0);
            }
        }
        return answer;
    }
}