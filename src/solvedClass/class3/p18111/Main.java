package solvedClass.class3.p18111;

import java.io.*;

public class Main {

    // 브루트포스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 제거해야 하는 블럭 수, 추가해야 하는 블럭 수
        int[][] list = new int[257][2];

        for (int h = 0; h <= 256; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] > h) {
                        // 제거해야 하는 블럭 수
                        list[h][0] += matrix[i][j] - h;
                    } else if (matrix[i][j] < h) {
                        // 추가해야 하는 블럭 수
                        list[h][1] += h - matrix[i][j];
                    }
                }
            }
        }

        int minTime = Integer.MAX_VALUE;
        int h = -1;
        for (int i = 0; i <= 256; i++) {
            int time = 2 * list[i][0] + list[i][1];
            int addBlock = list[i][1] - list[i][0];
            if (time <= minTime && addBlock <= b) {
                minTime = time;
                h = i;
            }
        }
        sb.append(minTime).append(" ").append(h);
        System.out.println(sb);
    }
}
