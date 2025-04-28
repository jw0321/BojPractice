package solvedClass.class3.p14940;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static int[][] distance;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputs2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(inputs2[j]);
                if (Integer.parseInt(inputs2[j]) == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        dfs(x, y);

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                }

                sb.append(distance[i][j]);
                if (j != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        int[] coordinate = {x, y};
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(coordinate);
        distance[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();
            int a = currentCoordinate[0];
            int b = currentCoordinate[1];

            int[][] nextCoordinate = {
                    {a + 1, b},
                    {a, b + 1},
                    {a - 1, b},
                    {a, b - 1}
            };

            for (int[] next : nextCoordinate) {
                if (next[0] >= 0 && next[0] < matrix.length && next[1] >= 0 && next[1] < matrix[0].length) {
                    if (matrix[next[0]][next[1]] != 0 && distance[next[0]][next[1]] == -1) {
                        distance[next[0]][next[1]] = distance[a][b] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
