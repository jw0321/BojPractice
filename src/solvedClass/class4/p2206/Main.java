package solvedClass.class4.p2206;

import java.io.*;
import java.util.*;

// BFS 문제
public class Main {

    static class Coordinate {

        int x, y, isBreakWall;

        public Coordinate(int x, int y, int isBreakWall) {
            this.x = x;
            this.y = y;
            this.isBreakWall = isBreakWall;
        }
    }

    static int[][] matrix;
    static int[][][] distance;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);

        matrix = new int[n][m];
        distance = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(input2[j]);
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        // 벽을 부순 갯수 추가
        distance[0][0][0] = 1;
        queue.offer(new Coordinate(0, 0, 0));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int isBreakWall = curr.isBreakWall;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nx == n - 1 && ny == m - 1) {
                        System.out.println(distance[x][y][isBreakWall] + 1);
                        return;
                    }
                    if (matrix[nx][ny] == 1 && isBreakWall == 0 && distance[nx][ny][1] == 0) {
                        distance[nx][ny][1] = distance[x][y][0] + 1;
                        queue.offer(new Coordinate(nx, ny, 1));
                    } else if (matrix[nx][ny] == 0 && distance[nx][ny][isBreakWall] == 0) {
                        distance[nx][ny][isBreakWall] = distance[x][y][isBreakWall] + 1;
                        queue.offer(new Coordinate(nx, ny, isBreakWall));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
