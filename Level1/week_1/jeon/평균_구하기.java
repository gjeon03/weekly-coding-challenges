import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).reduce(0, (a, c) -> a + c) / arr.length;
    }
}

/*
 * java에서 javascript의 reduce() 함수랑 같은 기능이 있다는걸 알고
 * 사용해서 풀이를 하려는데 문제가 두 가지가 있었음.
 * 1. java에서 / 로 나누기를 할 때 정수형으로 반환하기에 맨 앞에 형을 지정해줘야함.
 * 2. Arrays를 import 를 해야함.
 */