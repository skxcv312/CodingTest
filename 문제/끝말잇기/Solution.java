package 문제.끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Integer> map = new HashMap<>();

        map.put(words[0], 0);
        for (int i = 1; i < words.length; i++) {
            String fir = words[i - 1];
            String sec = words[i];

            if (map.containsKey(sec) || fir.charAt(fir.length() - 1) != sec.charAt(0)) {
                System.out.println(i);
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            map.put(words[i], 0);
        }

        return answer;
    }
}