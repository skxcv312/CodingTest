package 문제.해시_테이블함수;

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 정렬
        int c = col - 1;
        Arrays.sort(data, (a, b) -> {
            if (a[c] == b[c])
                return b[0] - a[0];
            return a[c] - b[c];
        });

        int col_size = data[0].length;
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;

            for (int k = 0; k < col_size; k++) {
                sum += data[i - 1][k] % i;
            }
            answer ^= sum;
        }

        return answer;
    }
}