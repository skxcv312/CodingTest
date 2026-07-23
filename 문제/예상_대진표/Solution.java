package 문제.예상_대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        a--;
        b--;
        while (a != b) {
            a = a / 2;
            b = b / 2;
            answer++;
        }
        return answer;
    }
}