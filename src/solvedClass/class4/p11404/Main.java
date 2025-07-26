package solvedClass.class4.p11404;

import java.io.*;
import java.util.*;

// 플로이드 워셜 문제
public class Main {

    static int[][] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        distance = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            distance[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int dist = Integer.parseInt(inputs[2]);
            if (dist < distance[start][end]) {
                distance[start][end] = dist;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == Integer.MAX_VALUE / 2) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
