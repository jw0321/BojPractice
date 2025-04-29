package solvedClass.class3.p11047;

import java.io.*;

public class Main {
    // 그리디 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= k) {
                ans += k / arr[i];
                k %= arr[i];
                if (k == 0) {
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
