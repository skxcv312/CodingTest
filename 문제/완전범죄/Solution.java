package 문제.완전범죄;

import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int max_n;
    int max_m;
    int[][] visited;

    public int solution(int[][] info, int n, int m) {
        max_n = n;
        max_m = m;

        visited = new int[info.length + 1][m];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp(info, 0, 0, 0);

        if (answer == Integer.MAX_VALUE)
            return -1;
        return answer;
    }

    void dp(int[][] info, int index, int a_size, int b_size) {
        if (a_size >= max_n || b_size >= max_m || a_size > answer)
            return;

        if (visited[index][b_size] <= a_size)
            return;

        if (info.length == index) {
            // System.out.println(a_size);
            answer = Math.min(answer, a_size);
            return;
        }

        visited[index][b_size] = a_size;

        int[] curr = info[index];
        dp(info, index + 1, a_size, b_size + curr[1]);
        dp(info, index + 1, a_size + curr[0], b_size);

    }

}