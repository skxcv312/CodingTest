package 문제.시소_짝꿍;

import java.util.*;

class Solution {

    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {

                // 정렬되어 있으므로 2배보다 커지면 이후도 전부 불가능
                if (weights[j] > weights[i] * 2)
                    break;

                if (isPair(weights[i], weights[j])) {
                    answer++;
                }
            }
        }

        return answer;
    }

    boolean isPair(int a, int b) {
        return a == b
                || a * 2 == b
                || a * 3 == b * 2
                || a * 4 == b * 3;
    }
}