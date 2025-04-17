package solvedClass.class2.p18110;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("0");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int c = Math.round(n * 0.15f);
        Arrays.sort(arr);

        int sum = 0;
        for (int i = c; i < n - c; i++) {
            sum += arr[i];
        }
        int avg = Math.round(sum / (float) (n - 2 * c));
        System.out.println(avg);

    }
}
