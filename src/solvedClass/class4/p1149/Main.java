package solvedClass.class4.p1149;

import java.io.*;

// DP 문제
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(input[0]);
            matrix[i][1] = Integer.parseInt(input[1]);
            matrix[i][2] = Integer.parseInt(input[2]);
        }

        int[][] dp = new int[n][3];

        // 초기값 설정
        dp[0] = new int[]{matrix[0][0], matrix[0][1], matrix[0][2]};

        // 점화식
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + matrix[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + matrix[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
