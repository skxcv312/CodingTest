package 문제.숫자_변환하기;

import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {

        Queue<int[]> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[y + 1];

        queue.offer(new int[] { x, 0 });

        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int depth = current[1];

            if (value == y)
                return depth;

            int[] nextValues = {
                    value + n,
                    value * 2,
                    value * 3
            };

            for (int next : nextValues) {
                if (next > y)
                    continue;

                if (visited[next])
                    continue;

                visited[next] = true;

                queue.offer(new int[] { next, depth + 1 });
            }
        }
        return -1;

    }

}