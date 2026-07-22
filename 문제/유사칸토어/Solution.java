package 문제.유사칸토어;

class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i = l - 1; i <= r - 1; i++){
            boolean flag = true;
            long start = i;
            while(start >= 5){
                if(start % 5 == 2){
                    flag = false;
                    break;
                }
                start /= 5;
            }
            if(start == 2) flag = false;
            if(flag) answer++;
        }
        return answer;
    }
}