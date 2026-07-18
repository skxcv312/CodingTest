package 문제.할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int dis_size = discount.length;

        Map<String, Integer> want_map = new HashMap<>();
        Map<String, Integer> dis_map = new HashMap<>();

        // 원하는 거 정립
        for (int i = 0; i < want.length; i++) {
            want_map.put(want[i], number[i]);
        }

        // 할인 품목 정립
        for (int start = 0; start < dis_size - 9; start++) {
            for (int i = start; i < start + 10; i++) {
                dis_map.put(
                        discount[i],
                        dis_map.getOrDefault(discount[i], 0) + 1);
            }

            answer += check(want_map, dis_map);
            dis_map.clear();
        }
        return answer;

    }

    int check(Map<String, Integer> want_map, Map<String, Integer> dis_map) {
        for (String want_key : want_map.keySet()) {
            int want_num = want_map.get(want_key);
            int dis_num = dis_map.getOrDefault(want_key, 0);
            if (want_num > dis_num)
                return 0;
        }
        return 1;

    }

}