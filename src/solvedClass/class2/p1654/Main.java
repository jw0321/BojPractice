package solvedClass.class2.p1654;

import java.io.*;
import java.util.*;

public class Main {
    // 이진 탐색 + 매개변수 탐색 활용해야 하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long start = 1;
        long end = arr[k - 1];
        long length = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long count = 0;

            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }
            if (count >= n) {
                length = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(length);
    }
}
