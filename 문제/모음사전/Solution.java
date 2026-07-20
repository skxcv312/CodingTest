package 문제.모음사전;

class Solution {
    int answer = -1;

    String[] alpha = {
            "A", "E", "I", "O", "U"
    };

    boolean flag = true;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    void dfs(String buffer, String target) {
        if (flag && buffer.length() < 6)
            answer++;
        else
            return;

        if (buffer.equals(target)) {
            flag = false;
            return;
        }

        for (int row = 0; row < 5; row++) {
            dfs(buffer + alpha[row], target);
        }
    }

}