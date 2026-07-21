package 문제.배달;

import java.util.*;

class Solution {
    List<int[]>[] map;
    int[] min_load;

    public int solution(int N, int[][] road, int K) {

        min_load = new int[N + 1];
        Arrays.fill(min_load, Integer.MAX_VALUE);

        map = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int len = r[2];

            map[start].add(new int[] { end, len });
            map[end].add(new int[] { start, len });

        }

        dijstra(1);

        int answer = 0;
        for (int m : min_load) {
            if (K >= m)
                answer++;
        }

        // System.out.println(Arrays.toString(min_load));

        return answer;
    }

    // 다익스트라
    void dijstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.offer(new int[] { start, 0 });
        min_load[start] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_node = curr[0];
            int curr_len = curr[1];

            // if(min_load[curr_node] <= curr_len) continue;

            for (int[] m : map[curr_node]) {
                int next_node = m[0];
                int next_len = m[1];

                if (min_load[next_node] <= curr_len + next_len)
                    continue;
                int min_len = curr_len + next_len;

                min_load[next_node] = min_len;
                queue.offer(new int[] { next_node, min_len });

            }

        }

    }

}