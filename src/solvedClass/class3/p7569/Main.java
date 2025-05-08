package solvedClass.class3.p7569;

import java.io.*;
import java.util.*;

public class Main {

    // 그래프 문제 (BFS) - 3차원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        int h = Integer.parseInt(inputs[2]);

        int[][][] box = new int[h][n][m];
        int[][][] distance = new int[h][n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                Arrays.fill(distance[i][j], -1);
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(input[k]);
                    if (box[i][j][k] != 0) {
                        distance[i][j][k] = 0;
                    }
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currZ = curr[0];
            int currY = curr[1];
            int currX = curr[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = currZ + dz[i];
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (nextZ >= 0 && nextZ < h && nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    if (box[nextZ][nextY][nextX] == 0 && distance[nextZ][nextY][nextX] == -1) {
                        distance[nextZ][nextY][nextX] = distance[currZ][currY][currX] + 1;
                        queue.offer(new int[]{nextZ, nextY, nextX});
                    }
                }
            }
        }

        int max = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (distance[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, distance[i][j][k]);
                }
            }
        }
        System.out.println(max);
    }
}
