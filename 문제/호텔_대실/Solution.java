package 문제.호텔_대실;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] time = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            String[] bang = book_time[i];
            time[i][0] = format(Integer.parseInt(bang[0].replace(":", "")));
            time[i][1] = format(Integer.parseInt(bang[1].replace(":", "")) + 10);
        }

        Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int cnt = 1;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if (time[j][0] < time[i][1]) {
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
            cnt = 1;
        }
        return answer;
    }

    int format(int time) {
        if (time % 100 > 60) {
            return time + 40;
        }
        return time;
    }
}