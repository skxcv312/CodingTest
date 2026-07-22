package 문제.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬 후 리스트
        Arrays.sort(people);

        int s = 0;
        int e = people.length - 1;
        int sum = people[e];

        System.out.println(Arrays.toString(people));

        while (s < e) {
            if (sum + people[s] <= limit) {
                s++;
            }
            answer++;
            e--;
            sum = people[e];

            if (s == e)
                answer++; // 한명만 남을 때

        }
        return answer;
    }
}