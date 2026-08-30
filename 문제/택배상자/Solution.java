package 문제.택배상자;

import java.util.*;

class Solution {

    Deque<Integer> subBelt = new ArrayDeque<>();
    int answer = 0;
    int index = 1;

    public int solution(int[] order) {
        for (int targetBox : order) {
            if (aa(targetBox))
                answer++;
            else
                break;

        }

        return answer;
    }

    public boolean aa(int targetBox) {
        while (targetBox > index) {
            subBelt.offerFirst(index++);
        }
        if (index == targetBox) {
            index++;
            return true;
        }

        if (subBelt.size() > 0 && subBelt.peekFirst() == targetBox) {
            subBelt.pollFirst();
            return true;
        }

        return false;

    }

}