package 문제.숫자카드_나누기;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = arrayA[0];
        int b = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            a = yaksu(arrayA[i], a);
            b = yaksu(arrayB[i], b);
        }

        if (no_yaksu(arrayB, a)) {
            answer = Math.max(a, answer);
        }

        if (no_yaksu(arrayA, b)) {
            answer = Math.max(b, answer);
        }

        return answer;
    }

    // 최대 공약수
    int yaksu(int a, int b) {
        while (b > 0) {
            int t = a % b; // 17 10 - 7
            a = b; // 10 7 - 3
            b = t; // 7 3 - 1
            // 3 1 - 0
        }
        return a;
    }

    boolean no_yaksu(int[] array, int yaksu) {
        for (int a : array) {
            if (a % yaksu == 0)
                return false;
        }
        return true;
    }

}