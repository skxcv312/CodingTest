package 문제.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        for (int i = 0; i < size - 1; i++) {
            int p = prices[i];
            int k = 0;

            for (int j = i + 1; j < size; j++) {
                k++;
                if (p > prices[j])
                    break;
            }

            answer[i] = k;
        }

        return answer;
    }
}