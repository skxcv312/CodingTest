package 문제.문자열_압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String v1 = s.substring(0, i);
            int cnt = 1;

            for (int j = i; j < s.length(); j += i) {
                String v2 = s.substring(j, Math.min(j + i, s.length()));

                if (v1.equals(v2)) {
                    cnt++;
                    continue;
                }

                if (cnt > 1)
                    sb.append(cnt);
                sb.append(v1);
                v1 = v2;
                cnt = 1;
            }
            if (cnt > 1)
                sb.append(cnt);
            sb.append(v1);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}