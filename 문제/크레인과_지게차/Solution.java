package 문제.크레인과_지게차;

import java.util.*;

class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    String[][] storage_list;
    boolean[][] visited;
    int h;
    int w;

    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        h = storage.length;
        w = storage[0].length();

        visited = new boolean[h][w];

        storage_list = new String[h][w];

        for (int row = 0; row < h; row++) {
            String[] split = storage[row].split("");
            for (int col = 0; col < w; col++) {
                storage_list[row][col] = split[col];
            }
        }
        //

        for (String re : requests) {
            String target = String.valueOf(re.charAt(0));
            if (re.length() == 2) { // 크레인
                answer += crain(target);
            } else {
                answer += zige(target);
            }

        }
        // System.out.println("범위 : " + h*w+ " 결과 : " + answer );

        return h * w - answer;
    }

    public int zige(String str) {
        List<int[]> removeList = new ArrayList<>();
        int sum = 0;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (storage_list[row][col].equals(str) && bfs(row, col)) {
                    sum++;
                    System.out.println("삭제 " + storage_list[row][col]);
                    removeList.add(new int[] { row, col });
                }

            }
        }
        for (int[] position : removeList) {

            storage_list[position[0]][position[1]] = "0";

        }
        return sum;
    }

    public int crain(String str) {
        int sum = 0;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (storage_list[row][col].equals(str)) {
                    sum++;
                    System.out.println("삭제 " + storage_list[row][col]);

                    storage_list[row][col] = "0";
                }

            }
        }
        return sum;
    }

    // 지게차 체크
    public boolean bfs(int row, int col) {
        if (row == 0 || row == h - 1 || col == 0 || col == w - 1) {

            return true;

        }

        visited = new boolean[h][w];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[row][col] = true;

        queue.offer(new int[] { row, col });

        while (!queue.isEmpty()) {
            int[] load = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = load[1] + dx[i];
                int next_y = load[0] + dy[i];

                if (next_x < 0 || next_x >= w || next_y < 0 || next_y >= h)
                    continue;
                if (visited[next_y][next_x] || storage_list[next_y][next_x] != "0")
                    continue;

                if (next_x == 0 || next_x == w - 1 || next_y == 0 || next_y == h - 1) {
                    return true;
                }

                visited[next_y][next_x] = true;
                queue.offer(new int[] { next_y, next_x });

            }

        }
        return false;
    }

}
