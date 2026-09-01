package 문제.삼각달팽이;

class Solution {

    int[][] move = {
            { 1, 0 },
            { 0, 1 },
            { -1, -1 }
    };

    public int[] solution(int n) {
        int size = 0;
        for (int i = 1; i <= n; i++) {
            size += i;
        }

        int m = 0;
        int dx = 0;
        int dy = 0;
        int[][] map = new int[n][n];
        map[0][0] = 1;
        for (int i = 2; i <= size; i++) {
            dy += move[m][0];
            dx += move[m][1];

            // 방향 바꾸기
            if (dy >= n || dx >= n || map[dy][dx] != 0) {
                dy -= move[m][0];
                dx -= move[m][1];
                m = (m + 1) % 3;
                i--;
                continue;
            }

            map[dy][dx] = i;

        }

        int index = 0;
        int[] answer = new int[size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}