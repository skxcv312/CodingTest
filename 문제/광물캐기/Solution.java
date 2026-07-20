package 문제.광물캐기;

import java.util.*;

class Solution {
    int[][] stat = {
            { 1, 1, 1 },
            { 5, 1, 1 },
            { 25, 5, 1 }
    };

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int picks_size = 0;
        for (int i = 0; i < 3; i++) {
            picks_size += picks[i];
        }

        int[][] mineral = new int[minerals.length / 5 + 1][3];

        for (int i = 0; i < minerals.length; i++) {
            if (i == picks_size * 5)
                break;

            int deps = i / 5;
            if ("diamond".equals(minerals[i]))
                mineral[deps][0]++;
            else if ("iron".equals(minerals[i]))
                mineral[deps][1]++;
            else if ("stone".equals(minerals[i]))
                mineral[deps][2]++;

        }

        Arrays.sort(mineral, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            if (a[1] != b[1])
                return b[1] - a[1];
            return b[2] - a[2];
        });

        for (int i = 0; i < mineral.length; i++) {
            if (0 < picks[0]) {
                answer += check(mineral[i], 0);
                picks[0]--;

            } else if (0 < picks[1]) {
                answer += check(mineral[i], 1);
                picks[1]--;

            } else if (0 < picks[2]) {
                answer += check(mineral[i], 2);
                picks[2]--;

            }

        }

        return answer;
    }

    int check(int[] pick, int tool) {
        int n = 0;

        for (int i = 0; i < 3; i++) {
            n += pick[i] * stat[tool][i];
        }

        return n;
    }

}