package solvedClass.class4.p12865;

import java.io.*;

// 0-1 배낭 문제 (DP로 풀이)
public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // 최대 무게가 i까지 일때 최대 가치
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            int weight = Integer.parseInt(input2[0]);
            int value = Integer.parseInt(input2[1]);

            for (int j = k; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        System.out.println(dp[k]);
    }
}
