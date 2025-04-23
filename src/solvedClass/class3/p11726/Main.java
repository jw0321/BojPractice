package solvedClass.class3.p11726;

import java.io.*;

public class Main {

    // DP 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        if (n == 1) {
            System.out.println("1");
            return;
        }

        // 초기값
        arr[1] = 1;
        arr[2] = 2;

        // 점화식
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[n]);
    }
}
