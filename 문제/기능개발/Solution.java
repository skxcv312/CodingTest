package 문제.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        List<Integer> ans_arr = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int end = 100 - progresses[i];

            int gg = end / speeds[i];
            if (end % speeds[i] != 0)
                gg++;

            list.add(gg);

        }

        int max = list.remove(0);
        int n = 1;
        while (!list.isEmpty()) {
            int peek = list.remove(0);

            if (max < peek) {
                max = peek;
                ans_arr.add(n);
                n = 1;

            } else
                n++;

            if (list.size() == 0)
                ans_arr.add(n);
        }

        int[] answer = new int[ans_arr.size()];
        int k = 0;
        while (!ans_arr.isEmpty()) {
            answer[k++] = ans_arr.remove(0);
        }

        return answer;
    }
}