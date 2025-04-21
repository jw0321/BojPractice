package solvedClass.class3.p1463;

import java.io.*;

public class Main {
    // 동적 계획법
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c;
            if (i % 3 == 0) {
                a = arr[i / 3] + 1;
            }
            if (i % 2 == 0) {
                b = arr[i / 2] + 1;
            }
            c = arr[i - 1] + 1;
            arr[i] = Math.min(Math.min(a, b), c);
        }
        System.out.println(arr[n]);
    }
}
