package solvedClass.class4.p9465;

import java.io.*;

// DP 문제
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];

            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(input[k]);
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (n == 1) {
                sb.append(Math.max(dp[0][0], dp[1][0]));
                if (i != t - 1) {
                    sb.append('\n');
                }
                continue;
            }

            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            if (n > 2) {
                for (int j = 2; j < n; j++) {
                    dp[0][j] = Math.max(Math.max(dp[0][j - 2], dp[1][j - 2]) + arr[0][j], dp[1][j - 1] + arr[0][j]);
                    dp[1][j] = Math.max(Math.max(dp[0][j - 2], dp[1][j - 2]) + arr[1][j], dp[0][j - 1] + arr[1][j]);
                }
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1]));
            if (i != t - 1) {
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
