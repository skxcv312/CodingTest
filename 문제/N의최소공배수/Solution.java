package 문제.N의최소공배수;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        // 공통 최대 공약수
        for (int i = 1; i < arr.length; i++) {
            int prime = getPrime(answer, arr[i]);
            answer = answer * arr[i] / prime;
        }
        return answer;
    }

    int getPrime(int a, int b) {
        while (b > 0) {
            int re = a % b;
            a = b;
            b = re;
        }
        return a;

    }
}