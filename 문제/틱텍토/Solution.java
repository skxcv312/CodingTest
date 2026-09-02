package 문제.틱텍토;

class Solution {
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;

        for (String row : board) {
            for (int i = 0; i < 3; i++) {
                char c = row.charAt(i);

                if (c == 'O')
                    oCnt++;
                else if (c == 'X')
                    xCnt++;
            }
        }

        // 기본 턴 규칙
        if (xCnt > oCnt)
            return 0;
        if (oCnt - xCnt > 1)
            return 0;

        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');

        // 둘 다 승리할 수 없음
        if (oWin && xWin)
            return 0;

        // O가 이겼으면 O가 마지막에 둔 것이므로 O가 하나 더 많아야 함
        if (oWin && oCnt != xCnt + 1)
            return 0;

        // X가 이겼으면 X가 마지막에 둔 것이므로 개수가 같아야 함
        if (xWin && oCnt != xCnt)
            return 0;

        return 1;
    }

    public boolean isWin(String[] board, char target) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target
                    && board[i].charAt(1) == target
                    && board[i].charAt(2) == target) {
                return true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == target
                    && board[1].charAt(i) == target
                    && board[2].charAt(i) == target) {
                return true;
            }
        }

        // 대각선
        if (board[0].charAt(0) == target
                && board[1].charAt(1) == target
                && board[2].charAt(2) == target) {
            return true;
        }

        if (board[0].charAt(2) == target
                && board[1].charAt(1) == target
                && board[2].charAt(0) == target) {
            return true;
        }

        return false;
    }

}