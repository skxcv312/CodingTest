package 문제.거리두기_확인하기;

import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }

    int check(String[] places) {
        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char ch = places[i].charAt(j);

                if (ch != 'P')
                    continue;
                if (visited[i][j])
                    continue;
                if (bfs(places, visited, i, j))
                    return 0;
            }
        }
        return 1;
    }

    boolean bfs(String[] places, boolean[][] visited, int row, int col) {
        int[] dr = new int[] { -1, 1, 0, 0 };
        int[] dc = new int[] { 0, 0, -1, 1 };

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { row, col, 0 });
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_row = curr[0] + dr[i];
                int next_col = curr[1] + dc[i];
                int next_dist = curr[2] + 1;

                if (next_row < 0 || next_row > 4 ||
                        next_col < 0 || next_col > 4)
                    continue;

                if (places[next_row].charAt(next_col) == 'X')
                    continue;

                if (visited[next_row][next_col])
                    continue;

                if (next_dist > 2)
                    continue;

                if (places[next_row].charAt(next_col) == 'P')
                    return true;

                visited[next_row][next_col] = true;
                queue.offer(new int[] { next_row, next_col, next_dist });
            }
        }
        return false;

    }
}