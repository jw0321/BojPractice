package solvedClass.class4.p11660;

import java.io.*;

// DP 문제
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Integer.parseInt(input2[j - 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] input3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(input3[0]);
            int y1 = Integer.parseInt(input3[1]);
            int x2 = Integer.parseInt(input3[2]);
            int y2 = Integer.parseInt(input3[3]);

            int sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
