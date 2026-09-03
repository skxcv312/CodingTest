package 문제.뒤큰수찾기;

import java.util.*;

class Solution {

    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        return answer;
    }
}