package 문제.N_Queen;

class Solution {

    int answer = 0;

    public int solution(int n) {
        int[][] board = new int[n][n];

        dfs(0, board, n);

        return answer;
    }

    void dfs(int row, int[][] board, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (board[row][col] != 0) {
                continue;
            }

            // 2차원 배열 깊은 복사
            int[][] currBoard = new int[n][n];
            for (int r = 0; r < n; r++) {
                currBoard[r] = board[r].clone();
            }

            // 퀸 배치
            currBoard[row][col] = -1;

            // 아래쪽
            for (int r = row + 1; r < n; r++) {
                currBoard[r][col] = 1;
            }

            // 왼쪽 아래 대각선
            int r = row + 1;
            int c = col - 1;

            while (r < n && c >= 0) {
                currBoard[r][c] = 1;
                r++;
                c--;
            }

            // 오른쪽 아래 대각선
            r = row + 1;
            c = col + 1;

            while (r < n && c < n) {
                currBoard[r][c] = 1;
                r++;
                c++;
            }

            dfs(row + 1, currBoard, n);
        }
    }
}