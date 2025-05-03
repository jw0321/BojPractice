package solvedClass.class3.p21736;

import java.io.*;

public class Main {

    static char[][] matrix;
    static boolean[][] visited;
    static int count = 0;
    // 그래프 문제 (DFS or BFS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        matrix = new char[n][m];
        visited = new boolean[n][m];
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

        dfs(x, y);
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    // dfs 로직 (재귀)
    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (matrix[x][y] == 'P') {
            count++;
        }

        int[][] nexts = {
                {x, y + 1},
                {x + 1, y},
                {x, y - 1},
                {x - 1, y}
        };
        for (int[] next : nexts) {
            if (next[0] >= 0 && next[1] >= 0 && next[0] < matrix.length && next[1] < matrix[0].length) {
                if (!visited[next[0]][next[1]] && matrix[next[0]][next[1]] != 'X') {
                    dfs(next[0], next[1]);
                }
            }
        }
    }
}
