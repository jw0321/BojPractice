package solvedClass.class3.p1260;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] matrix;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static int[] dfsNode;
    static int index;
    static int n;

    // 그래프 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        matrix = new boolean[n + 1][n + 1];
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];
        dfsNode = new int[n];

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            matrix[x][y] = true;
            matrix[y][x] = true;
        }

        index = 0;
        dfs(v);
        int[] bfsNode = bfs(v);

        for (int i = 0; i < n; i++) {
            if (dfsNode[i] != 0) {
                sb1.append(dfsNode[i]);
            }
            if (dfsNode[i] == 0 || i == n - 1) {
                break;
            }
            sb1.append(" ");
        }

        for (int i = 0; i < n; i++) {
            if (bfsNode[i] != 0) {
                sb2.append(bfsNode[i]);
            }
            if (bfsNode[i] == 0 || i == n - 1) {
                break;
            }
            sb2.append(" ");
        }

        System.out.println(sb1);
        System.out.println(sb2);
    }

    static void dfs(int start) {
        dfsVisited[start] = true;
        dfsNode[index] = start;
        index++;

        for (int j = 1; j <= n; j++) {
            if (matrix[start][j] && !dfsVisited[j]) {
                dfs(j);
            }
        }
    }

    static int[] bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] nodes = new int[1000];
        queue.offer(start);
        int i = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!bfsVisited[curr]) {
                nodes[i] = curr;
                i++;
            }
            bfsVisited[curr] = true;
            for (int j = 1; j <= n; j++) {
                if (matrix[curr][j] && !bfsVisited[j]) {
                    queue.offer(j);
                }
            }
        }
        return nodes;
    }
}
