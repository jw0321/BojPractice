package solvedClass.class4.p11053;

import java.io.*;
import java.util.*;

// 최장 증가 부분 수열 문제
public class Main_0 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        String[] inputs = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp){
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
