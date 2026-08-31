package 문제.석유시추;

import java.util.*;

class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    boolean[][] visited;
    int[] oilByCol;

    public int solution(int[][] land) {
        int answer = 0;

        int rowSize = land.length;
        int colSize = land[0].length;
        visited = new boolean[rowSize][colSize];
        oilByCol = new int[colSize];

        for (int c = 0; c < colSize; c++) {
            int oil = oilByCol[c];

            for (int r = 0; r < rowSize; r++) {
                oil += bfs(r, c, land);
            }
            answer = Math.max(oil, answer);
        }

        return answer;
    }

    public int bfs(int row, int col, int[][] land) {

        if (visited[row][col] || land[row][col] == 0) {
            return 0;
        }

        int rowSize = land.length;
        int colSize = land[0].length;
        int oil = 0;

        Set<Integer> cols = new HashSet<>();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { row, col });
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] move = queue.poll();
            oil++;
            cols.add(move[1]);

            for (int i = 0; i < 4; i++) {
                int dRow = move[0] + dr[i];
                int dCol = move[1] + dc[i];

                if (dRow < 0 || dRow >= rowSize || dCol < 0 || dCol >= colSize) {
                    continue;
                }

                if (land[dRow][dCol] == 0) {
                    continue;
                }

                if (visited[dRow][dCol]) {
                    continue;
                }

                visited[dRow][dCol] = true;
                queue.offer(new int[] { dRow, dCol });

            }
        }

        for (int c : cols) {
            oilByCol[c] += oil;
        }

        return oil;
    }

}