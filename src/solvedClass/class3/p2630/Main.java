package solvedClass.class3.p2630;

import java.io.*;

public class Main {

    static int whiteCount = 0;
    static int blueCount = 0;
    static int[][] matrix;

    // 분할 정복
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        cut(0, 0, n);
        sb.append(whiteCount).append("\n").append(blueCount).append("\n");
        System.out.println(sb);
    }

    // 재귀 함수
    static void cut (int x, int y, int size) {
        int sum = 0;
        // 각 칸의 색 찾기
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += matrix[i][j];
            }
        }
        if (sum == 0) {
            // 모든 칸이 0이면 -> 하얀색
            whiteCount++;
        } else if(sum == size * size) {
            // 모든 칸이 1이면 -> 파란색
            blueCount++;
        } else {
            // 모든 칸의 색이 같지 않으면
            int newSize = size / 2;
            cut(x, y, newSize);
            cut(x, y + newSize, newSize);
            cut(x + newSize, y, newSize);
            cut(x + newSize, y + newSize, newSize);
        }
    }
}
