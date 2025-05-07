package solvedClass.class3.p11403;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] matrix;
    static boolean[] visited;
    static int[][] routes;
    // 그래프 문제 (DFS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        matrix = new boolean[n][n];
        routes = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(inputs[j]) == 1) {
                    matrix[i][j] = true;
                }
            }
        }
        searchGraph(n);
        for (int[] route : routes) {
            for (int i = 0; i < route.length; i++) {
                sb.append(route[i]);
                if (i != route.length - 1) {
                    sb.append(" ");
                } else {
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    static void dfs(int x, List<Integer> route) {
        route.add(x);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[x][i] && !visited[i]) {
                visited[i]= true;
                dfs(i, route);
            }
        }
    }

    static void searchGraph(int n) {
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            List<Integer> route = new ArrayList<>();
            dfs(i, route);
            for (int j = 1; j < route.size(); j++) {
                routes[i][route.get(j)] = 1;
            }
        }
    }
}
