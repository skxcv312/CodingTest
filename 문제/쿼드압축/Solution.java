package 문제.쿼드압축;

class Solution {
    int[] answer = new int[2];
    boolean[][] visited;

    public int[] solution(int[][] arr) {

        int n = arr.length;
        visited = new boolean[n][n];

        while (0 < n) {
            for (int r = 0; r < arr.length; r += n) {
                for (int c = 0; c < arr.length; c += n) {
                    if (check(arr, r, c, n)) {
                        answer[arr[r][c]]++;
                    }
                }
            }
            n = n / 2;
        }
        return answer;
    }

    boolean check(int[][] arr, int r, int c, int n) {
        if (visited[r][c])
            return false;

        int standard = arr[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (standard != arr[i][j])
                    return false;
            }
        }

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                visited[i][j] = true;
            }
        }
        return true;
    }
}