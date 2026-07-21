package 문제.큰수_만들기;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            // 현재 숫자가 이전 숫자보다 크면 이전 숫자를 제거
            while (!stack.isEmpty()
                    && k > 0
                    && stack.peekLast() < current) {

                stack.pollLast();
                k--;
            }

            stack.offerLast(current);
        }

        // 숫자가 내림차순인 경우 제거하지 못한 k개를 뒤에서 제거
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pollFirst());
        }

        return answer.toString();
    }
}