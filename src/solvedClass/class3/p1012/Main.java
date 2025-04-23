package solvedClass.class3.p1012;

import java.io.*;

public class Main {

    // 그래프 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            // 가로 길이
            int m = Integer.parseInt(inputs[0]);

            // 세로 길이
            int n = Integer.parseInt(inputs[1]);

            // 배추의 개수
            int k = Integer.parseInt(inputs[2]);

            boolean[][] map = new boolean[m][n];
            boolean[][] notVisited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                String[] inputs2 = br.readLine().split(" ");
                int x = Integer.parseInt(inputs2[0]);
                int y = Integer.parseInt(inputs2[1]);

                map[x][y] = true;
                notVisited[x][y] = true;
            }

            Graph graph = new Graph(map, notVisited, k);

            sb.append(graph.searchGraph()).append("\n");
        }
        System.out.println(sb);
    }
}

class Graph {

    boolean[][] map;
    boolean[][] notVisited;
    int k;
    int count = 0;

    Graph(boolean[][] map, boolean[][] notVisited, int k) {
        this.map = map;
        this.notVisited = notVisited;
        this.k = k;
    }

    // DFS 로직
    void dfs(int x, int y) {
        count++;
        notVisited[x][y] = false;
        if (y < map[0].length - 1 && map[x][y + 1] && notVisited[x][y + 1]) {
            dfs(x, y + 1);
        }
        if (x < map.length - 1 && map[x + 1][y] && notVisited[x + 1][y]) {
            dfs(x + 1, y);
        }
        if (y > 0 && map[x][y - 1] && notVisited[x][y - 1]) {
            dfs(x, y - 1);
        }
        if (x > 0 && map[x - 1][y] && notVisited[x - 1][y]) {
            dfs(x - 1, y);
        }
    }

    // 전체 그래프 탐색
    int searchGraph() {
        int c = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] && notVisited[i][j]) {
                    c++;
                    dfs(i, j);
                }
            }
        }
        return c;
    }
}