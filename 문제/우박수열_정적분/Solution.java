package 문제.우박수열_정적분;

import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        List<Integer> list = new ArrayList<>();

        int ou = k;
        int n = 0;

        list.add(ou);
        while (ou != 1) {
            if (ou % 2 == 0)
                ou /= 2;
            else
                ou = ou * 3 + 1;
            list.add(ou);
        }

        int size = list.size();
        double[] wide = new double[size - 1];
        n = 0;
        int first = list.remove(0);
        while (!list.isEmpty()) {
            int second = list.remove(0);
            wide[n++] = (double) ((first + second) / 2.0);
            first = second;
        }

        // System.out.println(Arrays.toString(wide));

        List<Double> ans = new ArrayList<>();

        for (int[] range : ranges) {
            int x = range[0];
            int y = size + range[1] - 1;

            if (x > y) {
                ans.add(-1.0);
                continue;
            }

            double sum = 0.0;
            for (int i = x; i < y; i++) {
                sum += wide[i];
            }
            ans.add(sum);
        }

        double[] answer = new double[ans.size()];
        n = 0;
        while (!ans.isEmpty()) {
            answer[n++] = ans.remove(0);
        }

        return answer;
    }

}