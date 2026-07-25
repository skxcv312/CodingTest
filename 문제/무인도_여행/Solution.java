package 문제.무인도_여행;

import java.util.*;

class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    boolean[][] visited;
    char[][] board;

    int w;
    int h;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();

        h = maps.length;
        w = maps[0].length();

        board = new char[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] || board[i][j] == 'X')
                    continue;
                int v = bfs(i, j);
                list.add(v);
            }
        }

        if (list.isEmpty())
            return new int[] { -1 };

        list.sort(Comparator.naturalOrder());
        int[] answer = new int[list.size()];
        int n = 0;
        while (!list.isEmpty()) {
            answer[n++] = list.remove(0);
        }

        return answer;
    }

    int bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { r, c, board[r][c] - '0' });
        visited[r][c] = true;

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            sum += curr[2];

            for (int i = 0; i < 4; i++) {
                int next_r = curr[0] + dr[i];
                int next_c = curr[1] + dc[i];

                if (0 > next_r || next_r >= h
                        || 0 > next_c || next_c >= w)
                    continue;

                if (visited[next_r][next_c])
                    continue;

                if (board[next_r][next_c] == 'X')
                    continue;

                visited[next_r][next_c] = true;
                queue.offer(new int[] { next_r, next_c, board[next_r][next_c] - '0' });

            }

        }

        return sum;
    }
}