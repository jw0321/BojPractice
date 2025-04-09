package solvedClass.class2.p2775;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k + 1][n];

            // 0층의 호실별 인원
            for (int m = 0; m < n; m++) {
                arr[0][m] = m + 1;
            }

            // 1 ~ k 층의 호실별 인원
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < n; l++) {
                    int sum = 0;
                    for (int h = 0; h <= l; h++) {
                        sum += arr[j - 1][h];
                    }
                    arr[j][l] = sum;
                }
            }
            sb.append(arr[k][n - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
