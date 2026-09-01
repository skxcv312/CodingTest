package 문제.의상;

import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {

        for (String[] clothe : clothes) {
            String key = clothe[1];
            map.put(
                    key,
                    map.getOrDefault(key, 0) + 1);
        }

        int answer = 1;

        for (int count : map.values()) {
            answer *= count + 1;
        }

        return answer - 1;
    }

}