package solvedClass.class3.p7576;

import java.io.*;
import java.util.*;

public class Main {

    // 그래프 문제 -> 시작점이 2개 이상일 때 BFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.parseInt(line[j]);
                // 시작점이 2개 이상이면 초기 큐에 여러 시작점을 넣는다.
                if (line[j].equals("1")) {
                    queue.offer(new int[]{i, j});
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int[][] nexts = {
                    {curr[0] + 1, curr[1]},
                    {curr[0] - 1, curr[1]},
                    {curr[0], curr[1] + 1},
                    {curr[0], curr[1] - 1},
            };

            for (int[] next : nexts) {
                if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && visited[next[0]][next[1]] == 0) {
                    queue.offer(next);
                    visited[next[0]][next[1]] = 1;
                    distance[next[0]][next[1]] = distance[curr[0]][curr[1]] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                if (distance[i][j] > max) {
                    max = distance[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
