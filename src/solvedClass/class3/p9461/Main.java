package solvedClass.class3.p9461;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            long[] arr = new long[100];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;
            for (int j = 3; j < n; j++) {
                arr[j] = arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[n - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
