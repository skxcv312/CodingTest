package 문제.리코쳇_로봇;

import java.util.*;

class Solution {

    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, -1, 1 };

    int rowLen;
    int colLen;

    public int solution(String[] board) {
        rowLen = board.length;
        colLen = board[0].length();

        int startY = 0;
        int startX = 0;

        for (int y = 0; y < rowLen; y++) {
            for (int x = 0; x < colLen; x++) {
                if (board[y].charAt(x) == 'R') {
                    startY = y;
                    startX = x;
                }
            }
        }

        return bfs(board, startY, startX);
    }

    int bfs(String[] board, int startY, int startX) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowLen][colLen];

        queue.offer(new int[] { startY, startX, 0 });
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int y = current[0];
            int x = current[1];
            int count = current[2];

            if (board[y].charAt(x) == 'G') {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y;
                int nextX = x;

                // 벽이나 장애물을 만날 때까지 이동
                while (true) {
                    int moveY = nextY + dy[i];
                    int moveX = nextX + dx[i];

                    // 보드 범위를 벗어나면 현재 위치에서 멈춤
                    if (moveY < 0 || moveY >= rowLen ||
                            moveX < 0 || moveX >= colLen) {
                        break;
                    }

                    // 장애물을 만나면 현재 위치에서 멈춤
                    if (board[moveY].charAt(moveX) == 'D') {
                        break;
                    }

                    nextY = moveY;
                    nextX = moveX;
                }

                // 움직이지 않은 경우
                if (nextY == y && nextX == x) {
                    continue;
                }

                // 이미 방문한 정지 지점
                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;
                queue.offer(new int[] { nextY, nextX, count + 1 });
            }
        }

        return -1;
    }
}