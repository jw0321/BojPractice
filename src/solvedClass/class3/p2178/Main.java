package solvedClass.class3.p2178;

import java.io.*;
import java.util.*;

public class Main {

    // 그래프 문제 (BFS)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] matrix = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i + 1][j + 1] = line.charAt(j) == '1';
            }
        }

        boolean[][] visited = new boolean[n + 1][m + 1];
        int[][] distance = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 1});
        distance[1][1] = 1;
        visited[1][1] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m && !visited[nextX][nextY] && matrix[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    // 방문 체크를 언제 하냐에 따라 중복된 노드에 큐에 들어가는 일이 발생할 수 있다.
                    // 큐에 넣을때 방문 처리를 하거나 -> 큐에서 뺀 다음 방문처리가 되어 있다면 건너뛰는 방법이 있다.
                    visited[nextX][nextY] = true;
                    distance[nextX][nextY] = distance[curr[0]][curr[1]] + 1;
                }
            }
        }
        System.out.println(distance[n][m]);
    }
}
