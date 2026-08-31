package 문제.디펜스_게임;

import java.util.*;

class Solution {

    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = enemy.length;

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);

            if (n < 0 && k > 0) {
                n += pq.poll();
                k--;
            }

            if (n < 0 && k == 0) {
                answer = i;
                break;
            }

        }

        return answer;
    }

}