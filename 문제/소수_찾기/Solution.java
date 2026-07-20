package 문제.소수_찾기;

import java.util.*;

class Solution {

    int size;
    int answer = 0;

    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {

        String[] num = numbers.split("");

        size = num.length;
        boolean[] visited = new boolean[size];

        dfs(num, "", visited);

        for (Integer v : set) {
            if (isSosu(v))
                answer++;
        }

        return answer;
    }

    boolean isSosu(int n) {

        if (n == 2)
            return true;

        if (n % 2 == 0 || n < 2)
            return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    void dfs(String[] num, String buffer, boolean[] visited) {
        for (int i = 0; i < size; i++) {
            if (visited[i])
                continue;

            visited[i] = true;

            String next = buffer + num[i];

            set.add(Integer.parseInt(next));

            dfs(num, next, visited);

            visited[i] = false;

        }

    }

}