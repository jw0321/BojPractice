package solvedClass.class3.p30804;

import java.io.*;

public class Main {

    // 투포인터 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        int start = 0;
        int end = 0;
        int[] fruit = new int[10];
        int cate = 1;
        fruit[arr[0]] += 1;
        while (start < n && end < n) {

            if (cate < 3) {
                max = Math.max(max, end - start + 1);
                end++;
                if (end < n) {
                    fruit[arr[end]] += 1;
                    if (fruit[arr[end]] == 1) {
                        cate++;
                    }
                }
            } else {
                fruit[arr[start]] -= 1;
                if (fruit[arr[start]] == 0) {
                    cate--;
                }
                start++;
            }
        }

        System.out.println(max);
    }
}





