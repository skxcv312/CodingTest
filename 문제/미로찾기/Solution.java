package 문제.미로찾기;

import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, 1, -1 };

    int[] lever = new int[2];
    int[] start = new int[2];

    char[][] board;
    int row_size;
    int cow_size;

    public int solution(String[] maps) {
        row_size = maps.length;
        cow_size = maps[0].length();

        board = new char[row_size][cow_size];
        visited = new boolean[row_size][cow_size];

        for (int r = 0; r < row_size; r++) {
            for (int c = 0; c < cow_size; c++) {
                char temp = maps[r].charAt(c);
                if ('S' == temp) {
                    start[0] = r;
                    start[1] = c;
                } else if ('L' == temp) {
                    lever[0] = r;
                    lever[1] = c;
                }
                board[r][c] = temp;
            }
        }

        int a = bfs(start[0], start[1], 'L');
        visited = new boolean[row_size][cow_size];
        int b = bfs(lever[0], lever[1], 'E');
        if (a == -1 || b == -1)
            return -1;

        return a + b;
    }

    int bfs(int r, int c, char goal) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { r, c, 0 });

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int cow = temp[1];
            int num = temp[2];

            visited[row][cow] = true;

            if (goal == board[row][cow])
                return num;

            for (int i = 0; i < 4; i++) {
                int next_r = row + dr[i];
                int next_c = cow + dc[i];

                if (0 > next_r || next_r >= row_size ||
                        0 > next_c || next_c >= cow_size)
                    continue;

                if (visited[next_r][next_c])
                    continue;

                if ('X' != board[next_r][next_c]) {
                    visited[next_r][next_c] = true;
                    queue.offer(new int[] { next_r, next_c, num + 1 });
                }

            }
        }
        return -1;
    }
}