package solvedClass.class3.p2579;

import java.io.*;

public class Main {
    // 동적계획법 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[n + 1];
        // 초기 값
        sum[0] = 0;
        sum[1] = arr[1];
        if (n == 1) {
            System.out.println(sum[n]);
            return;
        }

        sum[2] = arr[1] + arr[2];
        if (n == 2) {
            System.out.println(sum[n]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            // 점화식
            int a = arr[i] + sum[i - 2];
            int b = arr[i] + arr[i - 1] + sum[i - 3];
            sum[i] = Math.max(a, b);
        }
        System.out.println(sum[n]);
    }
}
