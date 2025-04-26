package solvedClass.class3.p2805;

import java.io.*;

public class Main {

    // 이진 탐색 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
            max = Math.max(max, arr[i]);
        }

        int start = 0;
        int end = max;
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (mid < arr[j]) {
                    sum += arr[j] - mid;
                }
            }
            if (sum >= m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
