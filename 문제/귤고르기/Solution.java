package 문제.귤고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int target : tangerine) {
            map.put(
                    target,
                    map.getOrDefault(target, 0) + 1
                );
        }

        int[] temp = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            temp[index++] = map.get(key);
        }

        Arrays.sort(temp);

        int sum = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            sum += temp[i];
            answer++;
            if (sum >= k)
                break;

        }

        return answer;
    }
}