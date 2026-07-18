package 문제.K진수에서소수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String jinsu_num = jinsu(n, k);

        String[] jinsuArr = jinsu_num.split("0");

        for (String str : jinsuArr) {
            if (str.isEmpty())
                continue;
            if (sosu(str))
                answer++;
        }

        return answer;
    }

    // 소수 판별기
    boolean sosu(String str) {
        if (str.isEmpty())
            return false;

        long n = Long.parseLong(str);

        if (2 > n)
            return false;
        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;

    }

    // 진수 번환
    String jinsu(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}