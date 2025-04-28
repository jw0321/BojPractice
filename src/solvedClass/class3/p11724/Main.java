package solvedClass.class3.p11724;

import java.io.*;

public class Main {
    // 그래프 탐색 문제
    static boolean[][] matrix;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        matrix = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            matrix[a][b] = true;
            matrix[b][a] = true;
        }
        searchConnectedComponent();
    }

    static void searchConnectedComponent() {
        int component = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                component++;
            }
        }
        System.out.println(component);
    }

    static void dfs(int curr) {
        visited[curr] = true;
        for (int i = 1; i <= n; i++) {
            if (matrix[curr][i] && !visited[i]) {
                dfs(i);
            }
        }

    }
}
