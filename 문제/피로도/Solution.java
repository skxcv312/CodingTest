package 문제.피로도;


class Solution {
    int n;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;

        boolean[] visited = new boolean[n];
        drill(dungeons, visited, 0, k);

        return max;
    }

    void drill(int[][] dungeons, boolean[] visited, int row, int helth) {

        max = Math.max(max, row);

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (dungeons[i][0] > helth)
                continue;

            visited[i] = true;

            drill(dungeons, visited, row + 1, helth - dungeons[i][1]);

            visited[i] = false;
        }

    }

}