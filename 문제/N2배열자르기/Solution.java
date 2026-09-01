package 문제.N2배열자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = 0; i < right - left + 1; i++) {
            long index = left + i;
            long row = index / n;
            long col = index % n;

            answer[(int) i] = (int) Math.max(row, col) + 1;
        }

        return answer;
    }
}
