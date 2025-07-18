package solvedClass.class3.p14500;

import java.io.*;

public class Main {

    static int max = 0;
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // DFS 문제 - 브루트포스로도 풀 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputs2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs2[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                checkTshape(i, j);
            }
        }
        System.out.println(max);
    }

    //DFS 탐색
    private static void dfs(int x, int y, int depth, int sum) {
       if (depth == 4) {
           max = Math.max(max, sum);
           return;
       }

       for (int i = 0; i < 4; i++) {
           int nx = x + dx[i];
           int ny = y + dy[i];

           if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
               continue;
           }

           if (!visited[nx][ny]) {
               visited[nx][ny] = true;
               dfs(nx, ny, depth + 1, sum + map[nx][ny]);
               visited[nx][ny] = false;
           }
       }
    }

    // T 모양 체크
    private static void checkTshape(int x, int y) {
        int[][] wings = {
                {0, 1, 2},
                {0, 1, 3},
                {0, 2, 3},
                {1, 2, 3}
        };

        for (int i = 0; i < 4; i++) {
            int sum = map[x][y];
            boolean isPossible = true;

            for (int j = 0; j < 3; j++) {
                int wingIndex = wings[i][j];
                int nx = x + dx[wingIndex];
                int ny = y + dy[wingIndex];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    isPossible = false;
                    break;
                }
                sum += map[nx][ny];
            }

            if (isPossible) {
                max = Math.max(max, sum);
            }
        }
    }
}
