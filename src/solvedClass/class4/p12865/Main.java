package solvedClass.class4.p12865;

import java.io.*;

// 0-1 배낭 문제 (DP로 풀이)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(input2[0]);
            items[i][1] = Integer.parseInt(input2[1]);
        }

        int[][] dp = new int[n + 1][k + 1];

        // 1번째 물건부터 n번째 물건까지
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < items[i - 1][0]) {
                    // 해당 물건을 담을 수 없는 경우
                    // 이전 물건까지의 최대 가치와 같다.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 해당 물건을 담을 수 있는 경우
                    // 해당 물건을 담지 않는 경우와 해당 물건을 담는 경우 중 최대 가치가 된다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1][0]] + items[i - 1][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
