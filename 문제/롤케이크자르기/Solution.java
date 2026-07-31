package 문제.롤케이크자르기;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int t : topping) {
            map1.put(
                    t,
                    map1.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            map1.put(
                    t,
                    map1.get(t) - 1);

            if (map1.get(t) == 0)
                map1.remove(t);

            map2.put(
                    t,
                    map2.getOrDefault(t, 0) + 1);

            if (map1.size() == map2.size()) {
                answer++;
            }
        }

        return answer;
    }
}