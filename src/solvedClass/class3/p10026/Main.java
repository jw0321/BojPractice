package solvedClass.class3.p10026;

import java.io.*;
import java.util.*;

public class Main {
    // 그래프 문제 (BFS, DFS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[][] matrix1 = new char[n][n];
        char[][] matrix2 = new char[n][n];
        boolean[][] visited1 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = input.charAt(j);
                matrix2[i][j] = input.charAt(j);
                if (input.charAt(j) == 'G') {
                    matrix2[i][j] = 'R';
                }
            }
        }

        Queue<int[]> queue1 = new ArrayDeque<>();
        Queue<int[]> queue2 = new ArrayDeque<>();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    queue1.offer(new int[]{i, j});
                    visited1[i][j] = true;
                    count1++;
                    while (!queue1.isEmpty()) {
                        int[] curr = queue1.poll();
                        int[] dx = {0, 0, -1, 1};
                        int[] dy = {1, -1, 0, 0};
                        for (int k = 0; k < 4; k++) {
                            int nextX = curr[0] + dx[k];
                            int nextY = curr[1] + dy[k];
                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited1[nextX][nextY]
                                    && matrix1[nextX][nextY] == matrix1[curr[0]][curr[1]]) {
                                queue1.offer(new int[]{nextX, nextY});
                                visited1[nextX][nextY] = true;
                            }
                        }
                    }
                    if (!visited2[i][j]) {
                        queue2.offer(new int[]{i, j});
                        visited2[i][j] = true;
                        count2++;
                        while (!queue2.isEmpty()) {
                            int[] curr = queue2.poll();
                            int[] dx = {0, 0, -1, 1};
                            int[] dy = {1, -1, 0, 0};
                            for (int k = 0; k < 4; k++) {
                                int nextX = curr[0] + dx[k];
                                int nextY = curr[1] + dy[k];
                                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited2[nextX][nextY]
                                        && matrix2[nextX][nextY] == matrix2[curr[0]][curr[1]]) {
                                    queue2.offer(new int[]{nextX, nextY});
                                    visited2[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);
    }
}