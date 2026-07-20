package 문제.괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();

        String[] temp = new String[size];
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                int index = (i + j) % size;
                temp[j] = String.valueOf(s.charAt(index));
            }
            answer += check(temp);
        }

        return answer;
    }

    int check(String[] temp) {
        Deque<String> stack = new ArrayDeque<>();

        stack.offerLast(temp[0]);

        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");

        for (int i = 1; i < temp.length; i++) {
            String str_temp = stack.peekLast();
            if (temp[i].equals(map.get(str_temp))) {
                stack.pollLast();
                continue;
            }

            stack.offerLast(temp[i]);
        }
        // System.out.println(Arrays.toString(temp) + " - " + stack.isEmpty());

        if (stack.isEmpty())
            return 1;
        return 0;
    }
}