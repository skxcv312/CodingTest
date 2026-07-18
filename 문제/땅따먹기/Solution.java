package 문제.땅따먹기;

class Solution {
    int answer;

    int solution(int[][] land) {
        answer = 0;

        int size = land.length;
        for (int row = 1; row < size; row++) {
            for (int col = 0; col < 4; col++) {
                int max = 0;
                for (int i = 0; i < 4; i++) {
                    if (i == col)
                        continue;
                    max = Math.max(max, land[row - 1][i]);
                }
                land[row][col] += max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[size - 1][i]);
        }
        return answer;

    }
}
