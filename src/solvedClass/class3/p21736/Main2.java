package solvedClass.class3.p21736;

import java.io.*;
import java.util.*;

public class Main2 {

    static char[][] matrix;
    static int count;
    static int n;
    static int m;

    // 그래프 문제 (DFS or BFS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        matrix = new char[n][m];

        int x = -1, y = -1;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
                if (line.charAt(j) == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        count = 0;
        bfs(x, y);
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    // bfs 로직 (큐)
    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (matrix[curr[0]][curr[1]] == 'P') {
                count++;
            }

            int[][] nexts = {
                    {curr[0], curr[1] + 1},
                    {curr[0] + 1, curr[1]},
                    {curr[0], curr[1] - 1},
                    {curr[0] - 1, curr[1]}
            };

            for (int[] next : nexts) {
                if (next[0] >= 0 && next[1] >= 0 && next[0] < n && next[1] < m) {
                    if (matrix[next[0]][next[1]] != 'X' && !visited[next[0]][next[1]]) {
                        visited[next[0]][next[1]] = true;
                        queue.add(new int[]{next[0], next[1]});
                    }
                }
            }

        }
    }
}
