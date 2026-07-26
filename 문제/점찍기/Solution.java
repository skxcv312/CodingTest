package 문제.점찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (long x = 0; x <= d; x += k) {
            long h = (long) d * d - x * x;
            long n = (long) Math.sqrt(h);
            answer += n / k + 1;
        }
        return answer;
    }
}